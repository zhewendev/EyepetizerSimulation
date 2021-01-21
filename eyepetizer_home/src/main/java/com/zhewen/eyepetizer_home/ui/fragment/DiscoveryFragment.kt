package com.zhewen.eyepetizer_home.ui.fragment

import androidx.lifecycle.ViewModelProvider
import com.zhewen.eyepetizer_base.fragment.BaseMvvmFragment
import com.zhewen.eyepetizer_home.R
import com.zhewen.eyepetizer_home.databinding.FragmentHomeBinding
import com.zhewen.eyepetizer_home.viewmodel.DiscoveryFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoveryFragment: BaseMvvmFragment<FragmentHomeBinding, DiscoveryFragmentViewModel>() {

    override fun getViewModel(): DiscoveryFragmentViewModel {
        return ViewModelProvider(this)[DiscoveryFragmentViewModel::class.java]
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