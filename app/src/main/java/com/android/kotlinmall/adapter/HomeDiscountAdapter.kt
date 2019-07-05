package com.android.kotlinmall.adapter

import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.kotlinmall.R
import com.android.kotlinmall.utils.GlideUtils
import kotlinx.android.synthetic.main.layout_home_discount_item.view.*

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-07-05
 **
 ** Description is 首页打折的adapter
 **/

class HomeDiscountAdapter(val data: List<String>) : Adapter<HomeDiscountAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context)
            .inflate(R.layout.layout_home_discount_item,p0,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
     return   data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        //加载图片
        GlideUtils.loadUrlImage(holder.itemView.context,data.get(p1),holder.itemView.mGoodIconIv)
        //静态假数据
        holder.itemView.mDiscountAfterTv.text = "￥123.00"
        holder.itemView.mDiscountBeforeTv.text = "$1000.00"
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.mDiscountBeforeTv.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
            view.mDiscountBeforeTv.paint.isAntiAlias = true
        }
    }

}