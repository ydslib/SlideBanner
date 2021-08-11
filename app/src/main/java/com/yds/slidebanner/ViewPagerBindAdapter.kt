package com.yds.slidebanner

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager

object ViewPagerBindAdapter {

    @BindingAdapter("pageMargin")
    @JvmStatic
    fun bindViewPagerAdapter(
        viewPager: ViewPager,
        pageMargin:Float
    ){
        viewPager.pageMargin = dp2px(viewPager,pageMargin)
    }


    fun dp2px(view: View, dpValue: Float): Int {
        val scale = view.context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

}