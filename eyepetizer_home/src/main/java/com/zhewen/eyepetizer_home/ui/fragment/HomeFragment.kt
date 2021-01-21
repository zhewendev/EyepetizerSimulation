package com.zhewen.eyepetizer_home.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.zhewen.eyepetizer_base.fragment.BaseMvvmFragment
import com.zhewen.eyepetizer_home.R
import com.zhewen.eyepetizer_home.viewmodel.DiscoveryFragmentViewModel
import com.zhewen.eyepetizer_home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 首页Fragment
 */
@AndroidEntryPoint
class HomeFragment : BaseMvvmFragment<FragmentHomeBinding, DiscoveryFragmentViewModel>() {

    override fun getViewModel(): DiscoveryFragmentViewModel {
        return ViewModelProvider(this)[DiscoveryFragmentViewModel::class.java]
    }

    override fun getBindingVariable(): Int {
        return 0
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewDataBinding.apply {
            mViewModel.fetchDiscoveryModel().observe(viewLifecycleOwner, {  })
            lifecycleOwner = this@HomeFragment
        }
        mViewDataBinding.disconverViewModel = mViewModel
        Logger.t("HomeFragment").d("onViewCreated")
    }

    override fun onRetryBtnClick() {
    }

}