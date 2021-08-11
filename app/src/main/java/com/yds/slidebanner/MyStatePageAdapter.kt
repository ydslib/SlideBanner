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
}