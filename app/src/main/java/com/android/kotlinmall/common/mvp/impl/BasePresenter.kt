package com.android.mvp.impl

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import com.android.kotlinmall.AppContext
import com.android.kotlinmall.R
import com.android.mvp.IMvpView
import com.android.mvp.IPresenter
import com.bennyhuo.github.utils.Network

/**
 ** Create by android
 **
 ** Time at 2019-06-19
 **
 ** Description is
 **/


abstract class BasePresenter<out View : IMvpView<BasePresenter<View>>> : IPresenter<View> {

    override lateinit var view: @UnsafeVariance View

    override fun onCreate(savedInstanceState: Bundle?) {
    }

    override fun onSaveInstanceState(outState: Bundle) {
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
    }

    override fun onDestroy() {
    }

    override fun onStart() {
    }

    override fun onStop() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    fun checkNet(): Boolean {
        if (Network.isAvailable()) {
            return true
        }
        Toast.makeText(AppContext, AppContext.getString(R.string.networkUnuse), Toast.LENGTH_LONG).show()
        return false
    }
}