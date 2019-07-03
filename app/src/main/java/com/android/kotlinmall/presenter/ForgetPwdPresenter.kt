package com.android.kotlinmall.presenter

import com.android.kotlinmall.common.net.BaseException
import com.android.kotlinmall.common.net.BaseSubscriber
import com.android.kotlinmall.repository.UserRepority
import com.android.kotlinmall.ui.activity.ForgetPwdActivity
import com.android.mvp.impl.BasePresenter

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-06-28
 **
 ** Description is
 **/

class ForgetPwdPresenter : BasePresenter<ForgetPwdActivity>() {

    //开始注册

    fun forgetPwd(mobile: String, verifyCode: String) {
        if (!checkNet()) {
            return
        }
        view.showLoading()
        UserRepority.forgetPwd(mobile, verifyCode)
            .subscribe(object : BaseSubscriber<Boolean>() {
                override fun onNext(t: Boolean) {
                    view.hideLoading()
                    if (t) view.findPwdSuccess()
                }
                override fun onError(e: Throwable) {
                    if (e is BaseException) {
                        view.hideLoading()
                        view.findPwdError(e.msg)
                    }
                }
            })
    }
}