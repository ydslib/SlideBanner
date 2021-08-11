package com.yds.slidebanner

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyStatePageAdapter(manager: FragmentManager, behavior: Int, var taskList: List<String>) :
    FragmentStatePagerAdapter(manager,behavior) {
    override fun getCount(): Int {
        return taskList.size
    }

    override fun getItem(position: Int): Fragment {
        return SlideFragment.buildFragment(taskList[position],position.toString())
    }

    override fun getItemPosition(`object`: Any): Int {
        //因为在MainActivity的btn点击后更改tasklist数据，调用notifyDataSetChanged刷新数据，结果不刷新，需要重写本方法并返回POSITION_NONE
        return POSITION_NONE
    }
}