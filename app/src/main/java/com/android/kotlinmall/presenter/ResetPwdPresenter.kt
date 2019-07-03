package com.android.kotlinmall.presenter

import com.android.kotlinmall.common.net.BaseException
import com.android.kotlinmall.repository.UserRepority
import com.android.kotlinmall.ui.activity.ResetPwdActivity
import com.android.mvp.impl.BasePresenter
import com.orhanobut.logger.Logger

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-06-28
 **
 ** Description is
 **/

class ResetPwdPresenter : BasePresenter<ResetPwdActivity>() {

    //开始注册

    fun resetPwd(mobile: String, pwd: String) {
        if (!checkNet()) {
            return
        }
        view.showLoading()
        UserRepority.resetPwd(mobile, pwd)
            .subscribe({
                view.hideLoading()
                view.resetSuccess()
            }, {
                Logger.e(it.toString())
                view.hideLoading()
                if (it is BaseException) {
                    view.resetpwdError(it)
                }

            })
    }
}