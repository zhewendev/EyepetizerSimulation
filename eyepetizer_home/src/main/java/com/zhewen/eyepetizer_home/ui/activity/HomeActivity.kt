package com.zhewen.eyepetizer_home.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.zhewen.eyepetizer_common.route.ModuleRoute
import com.zhewen.eyepetizer_common.ui.BaseFullScreenActivity
import com.zhewen.eyepetizer_common.util.view.FragmentUtil
import com.zhewen.eyepetizer_home.R
import com.zhewen.eyepetizer_home.data.viewmodel.HomeActivityViewModel
import com.zhewen.eyepetizer_home.databinding.ActivityHomeBinding
import com.zhewen.eyepetizer_home.ui.fragment.HomeFragment

/**
 * 首页Activity
 */
@Route(path = ModuleRoute.Home.ACTIVITY_HOME)
class HomeActivity :
    BaseFullScreenActivity<ActivityHomeBinding, HomeActivityViewModel>() {

    private val mFragments = mutableListOf<Fragment>()
    private val mHomeFragment by lazy { HomeFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFragment()
        initView()

    }

    private fun initFragment() {
        mFragments.add(mHomeFragment)
        for (fragment in mFragments) {
            FragmentUtil.addFragment(this,fragment,mViewDataBinding.homeFragment.id)
        }
        FragmentUtil.showNewFragment(this,mHomeFragment,R.id.home_fragment)
    }

    /**
     * 初始化View
     */
    private fun initView() {
        mViewDataBinding.bottomNavView.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
        mViewDataBinding.bottomNavView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.navigation_home -> FragmentUtil.showNewFragment(this,mHomeFragment,R.id.home_fragment)
                R.id.navigation_community -> FragmentUtil.showNewFragment(this,mHomeFragment,R.id.home_fragment)        //todo
                R.id.navigation_publish -> FragmentUtil.showNewFragment(this,mHomeFragment,R.id.home_fragment)        //todo
                R.id.navigation_explore -> FragmentUtil.showNewFragment(this,mHomeFragment,R.id.home_fragment)          //todo
                R.id.navigation_user_center -> FragmentUtil.showNewFragment(this,mHomeFragment,R.id.home_fragment)          //todo
            }
            true
        }
        mViewDataBinding.bottomNavView.setOnNavigationItemReselectedListener {
            when(it.itemId) {
                R.id.navigation_home -> FragmentUtil.showNewFragment(this,mHomeFragment,R.id.home_fragment)             //todo item 双击监听处理
                R.id.navigation_community -> FragmentUtil.showNewFragment(this,mHomeFragment,R.id.home_fragment)        //todo
                R.id.navigation_publish -> FragmentUtil.showNewFragment(this,mHomeFragment,R.id.home_fragment)        //todo
                R.id.navigation_explore -> FragmentUtil.showNewFragment(this,mHomeFragment,R.id.home_fragment)          //todo
                R.id.navigation_user_center -> FragmentUtil.showNewFragment(this,mHomeFragment,R.id.home_fragment)          //todo
            }
        }
    }

    override fun getViewModel(): HomeActivityViewModel {
        return ViewModelProvider(this)[HomeActivityViewModel::class.java]
    }

    override fun getBindingVariable(): Int {
        return 0
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun onRetryBtnClick() {

    }

}