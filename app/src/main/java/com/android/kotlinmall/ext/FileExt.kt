package com.android.kotlinmall.ext

import android.util.Log
import com.android.kotlinmall.ext.no
import com.android.kotlinmall.ext.yes
import java.io.File

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-06-28
 **
 ** Description is
 **/

fun File.ensureDir(): Boolean {
    try {

        isDirectory.no {
            isFile.yes {
                delete()
            }
            return mkdirs()
        }
    } catch (e: Exception) {
        Log.e("TAG", e.message)

    }
    return false
}