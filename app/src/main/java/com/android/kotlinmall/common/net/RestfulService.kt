package com.android.baselibrary.common

import com.android.kotlinmall.AppContext
import com.android.kotlinmall.common.net.AcceptInterceptor
import com.android.kotlinmall.ext.ensureDir
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory2
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-06-28
 **
 ** Description is retrofit 工厂模式
 *
 **/


private const val BASE_URL = "http://192.168.1.51:8080/"

private const val TIME_CONNECT = 60L
//是否强制使用网络
const val FORCE_NETWORK = "forceNetwork"

private val cacheFile by lazy {
    File(AppContext.cacheDir, "webServiceApi").apply { ensureDir() }
}

val retrofit: Retrofit by lazy {
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(
            RxJava2CallAdapterFactory2.createWithSchedulers(
                Schedulers.io(),
                AndroidSchedulers.mainThread()
            )
        ).client(
            OkHttpClient.Builder()
                .connectTimeout(TIME_CONNECT, TimeUnit.SECONDS)
                .readTimeout(TIME_CONNECT, TimeUnit.SECONDS)
                .writeTimeout(TIME_CONNECT, TimeUnit.SECONDS)
                .addInterceptor(HttpLoggingInterceptor().setLevel(Level.BODY))
                .addInterceptor(AcceptInterceptor())
                .build()
        )
        .baseUrl(BASE_URL)
        .build()
}



