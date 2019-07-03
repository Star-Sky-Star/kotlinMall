package com.android.baselibrary.presenter

import com.android.baselibrary.presenter.view.BaseView

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-06-27
 **
 ** Description is
 **/

open class BasePresenter<T : BaseView> {
    lateinit var mView: T
}