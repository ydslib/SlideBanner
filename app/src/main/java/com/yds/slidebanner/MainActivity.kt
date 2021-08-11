package com.yds.slidebanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentStatePagerAdapter
import com.yds.slidebanner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val mAdapter by lazy {
        MyStatePageAdapter(supportFragmentManager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
            arrayListOf())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        binding.viewPager.adapter = mAdapter

        binding.lifecycleOwner = this

        val list = mutableListOf<String>()
        for (i in 0..5){
            list.add("test $i")
        }
        mAdapter.taskList = list
        mAdapter.notifyDataSetChanged()
    }
}