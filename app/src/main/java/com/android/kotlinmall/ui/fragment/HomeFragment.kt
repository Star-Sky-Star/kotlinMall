package com.android.kotlinmall.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.kotlinmall.R
import com.android.kotlinmall.adapter.HomeDiscountAdapter
import com.android.kotlinmall.adapter.HomeGalleryAdapter
import com.android.kotlinmall.constant.*
import com.android.kotlinmall.presenter.HomeFragmentPresenter
import com.android.kotlinmall.widgets.BannerImageLoader
import com.android.mvp.impl.BaseFragment
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_index.*

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-07-03
 **
 ** Description is首页
 **/


class HomeFragment : BaseFragment<HomeFragmentPresenter>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_index, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBanner()
        initNews()
        initDisCount()
        initmGallery()
    }

    private fun initDisCount() {
        mDisCountRecycler.layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mDisCountRecycler.adapter=HomeDiscountAdapter( listOf(
            HOME_DISCOUNT_ONE, HOME_DISCOUNT_TWO, HOME_DISCOUNT_THREE, HOME_DISCOUNT_FOUR,
            HOME_DISCOUNT_FIVE
        ))
    }

    private fun initmGallery() {
        mGallery.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mGallery.adapter = HomeGalleryAdapter(
            listOf(
                HOME_TOPIC_ONE, HOME_TOPIC_TWO, HOME_TOPIC_THREE, HOME_TOPIC_FOUR,
                HOME_TOPIC_FIVE
            )
        )
        PagerSnapHelper().attachToRecyclerView(mGallery)

    }

    private fun initBanner() {
        mHomeBanner.setImageLoader(BannerImageLoader())
        mHomeBanner.setImages(listOf(HOME_BANNER_ONE, HOME_BANNER_TWO, HOME_BANNER_THREE, HOME_BANNER_FOUR))
        mHomeBanner.setBannerAnimation(Transformer.Accordion)
        mHomeBanner.setDelayTime(2000)
        //设置指示器位置（当banner模式中有指示器时）
        mHomeBanner.setIndicatorGravity(BannerConfig.RIGHT)
        //banner设置方法全部调用完毕时最后调用
        mHomeBanner.start()
    }


    private fun initNews() {
        mNewsFlipper.setData(arrayOf("夏日炎炎，第一波福利还有30秒到达战场", "新用户立领1000元优惠券", "杭冬腊月的，来个冰淇淋吧"))
    }
}
