package com.android.baselibrary.ui.activity

import com.android.baselibrary.presenter.BasePresenter
import com.android.baselibrary.presenter.view.BaseView

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-06-27
 **
 ** Description is
 **/

open class BaseMvpActivity <T:BasePresenter<*>>: BaseActivity(),BaseView {

    lateinit var mpresenter:T

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError() {
    }


}