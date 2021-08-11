package com.yds.slidebanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.yds.slidebanner.databinding.FragmentSlideBinding

class SlideFragment : Fragment() {
    var mBinding: FragmentSlideBinding? = null

    companion object {
        fun buildFragment(content: String,index:String): SlideFragment {
            val fragment = SlideFragment()
            val bundle = Bundle()
            bundle.putString("content", content)
            bundle.putString("index",index)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate<FragmentSlideBinding>(
            inflater,
            R.layout.fragment_slide,
            container,
            false
        )
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val test = arguments?.get("content")
        val index = arguments?.get("index")
        mBinding?.tv?.text = "$test $index"

    }

}