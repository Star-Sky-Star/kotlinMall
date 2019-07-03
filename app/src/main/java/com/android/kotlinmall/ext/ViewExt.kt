package com.android.kotlinmall.ext

import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-07-02
 **
 ** Description is
 **/


/*
    扩展Button可用性
 */
fun Button.enable(et: EditText, method: () -> Boolean){
    val btn = this
    et.addTextChangedListener(object : DefaultTextWatcher(){
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}



open class DefaultTextWatcher:TextWatcher{
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

}