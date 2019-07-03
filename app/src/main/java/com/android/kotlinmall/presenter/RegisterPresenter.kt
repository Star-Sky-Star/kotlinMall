package com.android.kotlinmall.presenter

import android.annotation.SuppressLint
import com.android.kotlinmall.common.net.BaseException
import com.android.kotlinmall.repository.UserRepority
import com.android.kotlinmall.ui.activity.RegisterActivity
import com.android.mvp.impl.BasePresenter

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-06-28
 **
 ** Description is
 **/

class RegisterPresenter : BasePresenter<RegisterActivity>() {

    //开始注册

    @SuppressLint("CheckResult")
    fun doRegister(mobile: String, pwd: String, verifyCode: String) {

        if (!checkNet()) {
            return
        }
        view.showLoading()
        UserRepority.register(mobile, pwd, verifyCode)
            .subscribe({
                view.hideLoading()
                if (it) view.onRegisterSuccess()
            }, {
                view.hideLoading()
                view.onRegisterError(it as BaseException)
            })
    }


}