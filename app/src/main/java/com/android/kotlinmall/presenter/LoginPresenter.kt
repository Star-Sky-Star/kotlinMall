package com.android.kotlinmall.presenter

import android.annotation.SuppressLint
import com.android.kotlinmall.common.net.BaseException
import com.android.kotlinmall.repository.UserRepority
import com.android.kotlinmall.ui.activity.LoginActivity
import com.android.mvp.impl.BasePresenter

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-07-01
 **
 ** Description is
 **/

class LoginPresenter : BasePresenter<LoginActivity>() {
    @SuppressLint("CheckResult")
    fun doLogin(mobile: String, pwd: String, pushId: String) {
        if (!checkNet()) {
            return
        }
        view.showLoading()
        UserRepority.login(mobile, pwd, pushId)
            .subscribe({
                view.hideLoading()
                view.loginSuccess(it)
            }, {
                view.hideLoading()
                if (it is BaseException) {
                    view.showError(it.msg)
                }
            })

    }
}