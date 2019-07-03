package com.android.kotlinmall.common.net

import com.android.kotlinmall.repository.UserRepority
import okhttp3.Interceptor
import okhttp3.Response

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-06-28
 **
 ** Description is 定制acceptInterceptor
 **/
class AcceptInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val origin = chain.request()
        return chain.proceed(origin.newBuilder()
            .apply {
                header("Content-Type", "application/json")
                    .header("charset", "UTF-8")
                    .header("token", UserRepority.currentUser?.id ?: "")
            }
            .build())
    }

}