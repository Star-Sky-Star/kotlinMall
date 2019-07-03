package com.android.mvp

import android.content.res.Configuration
import android.os.Bundle

/**
 ** Create by android
 **
 ** Time at 2019-06-19
 **
 ** Description is
 **/

interface  ILifecycle{
    fun onCreate(savedInstanceState: Bundle?)

    fun onSaveInstanceState(outState: Bundle)

    fun onViewStateRestored(savedInstanceState: Bundle?)

    fun onConfigurationChanged(newConfig: Configuration)

    fun onDestroy()

    fun onStart()

    fun onStop()

    fun onResume()

    fun onPause()
}