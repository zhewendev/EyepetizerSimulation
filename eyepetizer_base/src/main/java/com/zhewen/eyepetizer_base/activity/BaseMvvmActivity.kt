package com.zhewen.eyepetizer_base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.zhewen.eyepetizer_base.viewmodel.IBaseMvvmViewModel

abstract class BaseMvvmActivity<V : ViewDataBinding, VM : IBaseMvvmViewModel>:AppCompatActivity(),IBaseView {

    lateinit var mViewModel:VM
    lateinit var mViewDataBinding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    private fun initViewModel(){

    }

    /**
     * 获取ViewModel
     */
    protected abstract fun getViewModel():VM

    /**
     * 获取布局资源ID
     */
    @LayoutRes
    protected abstract fun getLayoutId(): Int


}