package com.android.kotlinmall.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.android.kotlinmall.R
import com.android.kotlinmall.utils.GlideUtils

/**
 * * Create by 对方已经拉黑你
 * *
 * * Time at 2019-07-04
 * *
 * * Description is 首页画廊的adapter
 */
class HomeGalleryAdapter(val  mList: List<String>) : RecyclerView.Adapter<HomeGalleryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val inflate = LayoutInflater.from(viewGroup.context).inflate(R.layout.activity_main_gallery_item, viewGroup,
            false)
        return ViewHolder(inflate)

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        GlideUtils.loadImage(viewHolder.itemView.context, mList[position], viewHolder.mTopic)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTopic: ImageView = itemView.findViewById(R.id.mTopicIv)
    }
}
