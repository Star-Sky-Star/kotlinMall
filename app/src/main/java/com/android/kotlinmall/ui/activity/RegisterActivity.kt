package com.android.kotlinmall.ui.activity

import android.os.Bundle
import com.android.kotlinmall.R
import com.android.kotlinmall.common.AppManager
import com.android.kotlinmall.common.net.BaseException
import com.android.kotlinmall.ext.enable
import com.android.kotlinmall.presenter.RegisterPresenter
import com.android.mvp.impl.BaseActivity
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class RegisterActivity : BaseActivity<RegisterPresenter>() {

    private var pressTime: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)
        mRegisterBtn.enable(mPhone, { isBtnEnable() })
        mRegisterBtn.enable(mPhone, { isBtnEnable() })
        mRegisterBtn.enable(mVerifyEt, { isBtnEnable() })

        mRegisterBtn.onClick {
            presenter.doRegister(mPhone.text.toString().trim(), mPwd.text.toString().trim(), "123456")
        }

        mVerifyBtn.onClick {
            mVerifyBtn.requestSendVerifyNumber()
        }
    }


    fun onRegisterError(e: BaseException) {
        toast(e.msg)
        Logger.e(e.msg)
    }

    fun onRegisterSuccess() {
        toast("注册成功")
    }


    /*
      判断按钮是否可用
   */
    private fun isBtnEnable(): Boolean {
        return mPhone.text.isNullOrEmpty().not() &&
                mVerifyEt.text.isNullOrEmpty().not() &&
                mPwd.text.isNullOrEmpty().not()
    }


    /* private fun showProgress(show: Boolean) {
         val shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime)
         mFormLayout.animate().setDuration(shortAnimTime.toLong()).alpha(
             (if (show) 0 else 1).toFloat()
         ).setListener(object : AnimatorListenerAdapter() {
             override fun onAnimationEnd(animation: Animator) {
                 mFormLayout.visibility = if (show) View.GONE else View.VISIBLE
             }
         })

         mRegisterProgress.animate().setDuration(shortAnimTime.toLong()).alpha(
             (if (show) 1 else 0).toFloat()
         ).setListener(object : AnimatorListenerAdapter() {
             override fun onAnimationEnd(animation: Animator) {
                 mRegisterProgress.visibility = if (show) View.VISIBLE else View.GONE
             }
         })
     }*/


    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast("再点一次退出程序")
            pressTime = time
        } else {
            AppManager.instance.exitApp(this)
        }
    }

}
