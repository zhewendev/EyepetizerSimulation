package com.zhewen.eyepetizer_common.ui

import android.graphics.Color
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.zhewen.eyepetizer_base.activity.BaseMvvmActivity
import com.zhewen.eyepetizer_base.viewmodel.IBaseViewModel
import com.zhewen.eyepetizer_common.util.device.StatusBarUtil

/**
 * 沉浸式Activity基类
 */
abstract class BaseFullScreenActivity<V : ViewDataBinding, VM : IBaseViewModel>:BaseMvvmActivity<V,VM>() {


    override fun initBaseConfig() {
        StatusBarUtil.setStatusBarLightMode(this, true)
        StatusBarUtil.setStatusBarVisibility(this, false)
        StatusBarUtil.setStatusBarColor(this, Color.TRANSPARENT)
    }
}