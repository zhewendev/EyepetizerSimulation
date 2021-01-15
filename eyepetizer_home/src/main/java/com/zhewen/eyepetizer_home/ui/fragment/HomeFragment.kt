package com.zhewen.eyepetizer_home.ui.fragment

import androidx.lifecycle.ViewModelProvider
import com.zhewen.eyepetizer_base.base.BaseApplication
import com.zhewen.eyepetizer_base.fragment.BaseMvvmFragment
import com.zhewen.eyepetizer_home.R
import com.zhewen.eyepetizer_home.data.factory.HomeFragmentModelFactory
import com.zhewen.eyepetizer_home.data.viewmodel.HomeFragmentViewModel
import com.zhewen.eyepetizer_home.databinding.FragmentHomeBinding

/**
 * 首页Fragment
 */
class HomeFragment : BaseMvvmFragment<FragmentHomeBinding, HomeFragmentViewModel>() {

    override fun getViewModel(): HomeFragmentViewModel {
        return ViewModelProvider(this,HomeFragmentModelFactory())[HomeFragmentViewModel::class.java]
    }

    override fun getBindingVariable(): Int {
        return 0
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onRetryBtnClick() {
    }

}