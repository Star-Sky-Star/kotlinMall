package com.android.kotlinmall.common.net

import io.reactivex.Observable
import io.reactivex.functions.Function

class BaseFunc<T> : Function<BaseResp<T>, Observable<out T>> {
    override fun apply(t: BaseResp<T>): Observable<out T> {
        if (t.status != ResultCode.SUCCESS) {
          return  Observable.error(BaseException(t.status, t.message))
        } else {
          return  Observable.just(t.data)
        }
    }
}
