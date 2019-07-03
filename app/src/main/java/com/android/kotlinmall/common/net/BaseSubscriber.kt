package com.android.kotlinmall.common.net

import io.reactivex.Observer
import io.reactivex.disposables.Disposable


/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-06-30
 **
 ** Description is
 **/


abstract class BaseSubscriber<T> : Observer<T> {

    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {


    }

    override fun onNext(t: T) {


    }

    override fun onError(e: Throwable) {

    }

}