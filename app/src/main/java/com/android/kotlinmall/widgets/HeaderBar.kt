package com.android.kotlinmall.widgets

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.android.kotlinmall.R
import kotlinx.android.synthetic.main.layout_header_bar.view.*
import org.jetbrains.anko.dip
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-07-01
 **
 ** Description is
 **/

class HeaderBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var isShowBack = true
    private var titleText: String? = null
    private var rightText: String? = null

    init {

        val typeArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar)

        isShowBack = typeArray.getBoolean(R.styleable.HeaderBar_isShowBack, true)
        titleText = typeArray.getString(R.styleable.HeaderBar_titleText)
        rightText = typeArray.getString(R.styleable.HeaderBar_rightText)

        initView()

        typeArray.recycle()

    }

    private fun initView() {

        View.inflate(context, R.layout.layout_header_bar, this)
        mLeftIv.visibility = if (isShowBack) View.VISIBLE else View.GONE

        titleText?.let {
            mTitleTv.text = it
        }
        rightText?.let {
            mRightTv.text = it
        }
        mLeftIv.onClick {
            if (context is Activity) {
                (context as Activity).finish()
            }
        }
    }


}