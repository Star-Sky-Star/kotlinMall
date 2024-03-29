package com.bennyhuo.github.utils



import com.android.kotlinmall.AppContext
import com.android.kotlinmall.ext.Preference
import kotlin.reflect.jvm.jvmName

/**
 * Created by benny on 6/23/17.
 */
inline fun <reified R, T> R.pref(default: T) = Preference(AppContext, "", default, R::class.jvmName)