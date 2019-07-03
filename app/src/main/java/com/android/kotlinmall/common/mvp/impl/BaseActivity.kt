package com.android.mvp.impl

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.kotlinmall.common.AppManager
import com.android.kotlinmall.widgets.ProgressLoading
import com.android.mvp.IMvpView
import com.android.mvp.IPresenter
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.jvmErasure

/**
 ** Create by android
 **
 ** Time at 2019-06-19
 **
 ** Description is
 **/


abstract class BaseActivity<out P : BasePresenter<BaseActivity<P>>> : IMvpView<P>, AppCompatActivity() {

    override val presenter: P
    lateinit var mLoadingProgress: ProgressLoading

    init {

        presenter = creatPresenterKt()
        presenter.view = this


    }


    fun creatPresenterKt(): P {
        sequence {
            var thisClass: KClass<*> = this@BaseActivity::class
            while (true) {
                yield(thisClass.supertypes)
                thisClass = thisClass.supertypes.firstOrNull()?.jvmErasure ?: break
            }
        }.flatMap {
            it.flatMap { it.arguments }.asSequence()
        }.first {
            it.type?.jvmErasure?.isSubclassOf(IPresenter::class) ?: false
        }.let {
            return it.type!!.jvmErasure.primaryConstructor!!.call() as P
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
        mLoadingProgress = ProgressLoading.create(this)
        presenter.onCreate(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {}


    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        onViewStateRestored(savedInstanceState)
        presenter.onViewStateRestored(savedInstanceState)

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun showLoading() {
        mLoadingProgress.showLoading()
    }


    override fun hideLoading() {
        mLoadingProgress.hideLoading()
    }


}
