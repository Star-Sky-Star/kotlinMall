package com.android.kotlinmall.presenter

import com.android.kotlinmall.repository.UploadRepority
import com.android.kotlinmall.repository.UserRepority
import com.android.kotlinmall.ui.activity.UserInfoActivity
import com.android.mvp.impl.BasePresenter
import com.orhanobut.logger.Logger

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-07-02
 **
 ** Description is
 **/

class UserInfoPresenter : BasePresenter<UserInfoActivity>() {

    fun getUploadtoken() {
        if (!checkNet())
            return
        view.showLoading()

        UploadRepority.getUploadToken().subscribe({
            view.hideLoading()
            view.onGetUploadTokenResult(it)
        }, {
            Logger.e("$it")
            view.hideLoading()
        })
    }

    fun editUser( userName: String, userIcon: String, gender: String, sign: String) {
        if (!checkNet())
            return
        view.showLoading()

        UserRepority.editUser( userName, userIcon, gender, sign).subscribe({
            view.hideLoading()
            UserRepority.currentUser = it
            view.editUserSuccess()
        }, {
            Logger.e("$it")
            view.editUserError()
            view.hideLoading()
        })
    }

}