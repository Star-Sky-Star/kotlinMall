package com.android.kotlinmall.common.net

import android.util.Base64
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val origin = chain.request()
        return chain.proceed(origin.newBuilder()
            .apply {
                when {
                    origin.url.pathSegments.contains("authorizations") -> {
                        val userCredentials = "abc"
                        val auth =
                            "Basic " + String(Base64.decode(userCredentials.toByteArray(), Base64.DEFAULT)).trim()
                        header("Authorization", auth)
                    }
                    else -> {
                        val auth = "Token "
                        header("Authorization", auth)
                    }
                }
            }.build()
        )

    }

}
