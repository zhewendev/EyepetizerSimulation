package com.zhewen.eyepetizer_common.ui

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.zhewen.eyepetizer_base.activity.BaseMvvmActivity
import com.zhewen.eyepetizer_base.viewmodel.IBaseViewModel

/**
 * 沉浸式Activity基类
 */
// TODO: 2021/1/5
abstract class BaseFullScreenActivity<V : ViewDataBinding, VM : IBaseViewModel>:BaseMvvmActivity<V,VM>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //todo
        super.onCreate(savedInstanceState)
    }
}