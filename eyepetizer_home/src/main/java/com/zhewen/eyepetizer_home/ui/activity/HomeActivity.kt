package com.zhewen.eyepetizer_home.ui.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.zhewen.eyepetizer_base.activity.BaseMvvmActivity
import com.zhewen.eyepetizer_base.viewmodel.BaseViewModel
import com.zhewen.eyepetizer_common.route.ModuleRoute
import com.zhewen.eyepetizer_home.R
import com.zhewen.eyepetizer_home.databinding.ActivityHomeBinding

/**
 * 首页Activity
 */
@Route(path = ModuleRoute.Home.ACTIVITY_HOME)
class HomeActivity :
    BaseMvvmActivity<ActivityHomeBinding, BaseViewModel>() {

    override fun getViewModel(): BaseViewModel {
        TODO("Not yet implemented")
    }

    override fun getBindingVariable(): Int {
        TODO("Not yet implemented")
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun onRetryBtnClick() {
        TODO("Not yet implemented")
    }

}