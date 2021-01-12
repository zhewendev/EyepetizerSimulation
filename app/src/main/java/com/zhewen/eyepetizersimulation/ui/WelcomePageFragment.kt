package com.zhewen.eyepetizersimulation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zhewen.eyepetizersimulation.R
import com.zhewen.eyepetizersimulation.adapter.ImageTitleAdapter
import com.zhewen.eyepetizersimulation.bean.ImageTitleBean
import com.zhewen.eyepetizersimulation.databinding.FragmentWelcomePageBinding

class WelcomePageFragment : Fragment() {

    private lateinit var mWelcomePageBinding: FragmentWelcomePageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mWelcomePageBinding = FragmentWelcomePageBinding.inflate(inflater, container, false)
        return mWelcomePageBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mWelcomePageBinding.welcomePageBanner.adapter = ImageTitleAdapter(getImageTitleListData())
    }

    private fun getImageTitleListData(): MutableList<ImageTitleBean> {
        val imageTitleList = mutableListOf<ImageTitleBean>()
        imageTitleList.add(
            ImageTitleBean(
                R.drawable.main_splash_bg, title = "在这里\n你可以听到周围人的心声"
            )
        )
        imageTitleList.add(
            ImageTitleBean(
                R.drawable.main_splash_bg, title = "在这里\nTA会在下一秒遇见你"
            )
        )
        imageTitleList.add(
            ImageTitleBean(
                R.drawable.main_splash_bg, title = "在这里\n不再错过可以改变你一生的人"
            )
        )
        return imageTitleList
    }
}