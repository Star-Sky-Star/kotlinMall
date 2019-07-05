package com.android.kotlinmall.widgets.gallery

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import kotlin.math.max
import kotlin.math.min

/**
 * * Create by 对方已经拉黑你
 * *
 * * Time at 2019-07-04
 * *
 * * Description is
 */
class SpeedRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    override fun fling(velocityX: Int, velocityY: Int): Boolean {
        var velocityX = velocityX
        var velocityY = velocityY
        velocityX = solveVelocity(velocityX)
        velocityY = solveVelocity(velocityY)
        return super.fling(velocityX, velocityY)
    }

    private fun solveVelocity(velocity: Int): Int {
        return if (velocity > 0) {
            min(velocity, FLING_MAX_VELOCITY)
        } else {
            max(velocity, -FLING_MAX_VELOCITY)
        }
    }

    companion object {
        private val FLING_SCALE_DOWN_FACTOR = 0.5f // 减速因子
        private val FLING_MAX_VELOCITY = 8000 // 最大顺时滑动速度
    }
}
