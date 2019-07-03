package com.android.kotlinmall

import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger.addLogAdapter
import com.orhanobut.logger.PrettyFormatStrategy


/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-06-28
 **
 ** Description is
 **/


private lateinit var INSTANCE: Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
       // MultiDex.install(this);
        addLogAdapter(object : AndroidLogAdapter(
            PrettyFormatStrategy.newBuilder()
                .tag("KotlinMall")
                .build()
        ) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }


        })
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }
}

object AppContext : ContextWrapper(INSTANCE)