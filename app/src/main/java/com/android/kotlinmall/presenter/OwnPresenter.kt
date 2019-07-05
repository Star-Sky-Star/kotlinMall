package com.android.kotlinmall.presenter

import com.android.kotlinmall.common.net.BaseException
import com.android.kotlinmall.repository.UserRepority
import com.android.kotlinmall.ui.fragment.UserInfoFragment
import com.android.mvp.impl.BasePresenter

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-07-05
 **
 ** Description is
 **/


class OwnPresenter : BasePresenter<UserInfoFragment>() {

    fun getUser() {
        if (!checkNet()) {
            return
        }
        view.showLoading()
        UserRepority.getUserInfo()
            .subscribe({
                view.hideLoading()
                view.refreshUser(it)
            }, {
                view.hideLoading()
                if (it is BaseException) {

                }
            })
    }

}