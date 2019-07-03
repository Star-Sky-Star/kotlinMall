package com.bennyhuo.github.utils

import com.android.kotlinmall.AppContext
import org.jetbrains.anko.connectivityManager

object Network {
    @Suppress("DEPRECATION")
    fun isAvailable(): Boolean = AppContext.connectivityManager.activeNetworkInfo?.isAvailable ?: false
}