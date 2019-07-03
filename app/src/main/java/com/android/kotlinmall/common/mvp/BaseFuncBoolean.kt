package com.android.kotlinmall.common.mvp

import com.android.kotlinmall.common.net.BaseException
import com.android.kotlinmall.common.net.BaseResp
import com.android.kotlinmall.common.net.ResultCode
import io.reactivex.Observable
import io.reactivex.functions.Function

class BaseFuncBoolean<T> : Function<BaseResp<T>, Observable<Boolean>> {
    override fun apply(t: BaseResp<T>): Observable<Boolean> {
        if (t.status != ResultCode.SUCCESS) {
          return  Observable.error(BaseException(t.status, t.message))
        } else {
          return  Observable.just(true)
        }
    }

}
