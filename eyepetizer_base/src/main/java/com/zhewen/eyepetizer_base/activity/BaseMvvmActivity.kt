package com.zhewen.eyepetizer_base.activity

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.zhewen.eyepetizer_base.loadsir.EmptyCallback
import com.zhewen.eyepetizer_base.loadsir.ErrorCallback
import com.zhewen.eyepetizer_base.loadsir.LoadingCallback
import com.zhewen.eyepetizer_base.loadsir.NoNetworkCallback
import com.zhewen.eyepetizer_base.viewmodel.IBaseViewModel

/**
 * MVVM架构的Activity基类
 */
abstract class BaseMvvmActivity<V : ViewDataBinding, VM : IBaseViewModel> :
    AppCompatActivity(), IBaseView {

    lateinit var mViewModel: VM
    lateinit var mViewDataBinding: V
    lateinit var mLoadService: LoadService<Any>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()
        initDataBinding()
    }

    /**
     * 初始化ViewModel，并关联视图
     */
    private fun initViewModel() {
        mViewModel = getViewModel()
    }

    /**
     * 初始化处理Databinding视图绑定问题
     */
    private fun initDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        if (getBindingVariable() > 0) {
            mViewDataBinding.setVariable(getBindingVariable(), mViewModel)
        }
        mViewDataBinding.executePendingBindings()   //刷新UI视图

    }

    /**
     * 注册LoadSir回调框
     */
    fun registerLoadSir(view: View) {
        if (!this::mLoadService.isInitialized) {
            mLoadService = LoadSir.getDefault().register(
                view
            ) { onRetryBtnClick() }
        }
    }

    private var mIsShowedContent = false

    override fun showContent() {
        if (this::mLoadService.isInitialized){
            mIsShowedContent = true
            mLoadService.showSuccess()
        }
    }

    override fun showLoading() {
        if (this::mLoadService.isInitialized){
            mLoadService.showCallback(LoadingCallback::class.java)
        }
    }

    override fun showEmptyPage() {
        if (this::mLoadService.isInitialized){
            mLoadService.showCallback(EmptyCallback::class.java)
        }
    }

    override fun showError(message:String) {
        if (this::mLoadService.isInitialized){
            if (mIsShowedContent) mLoadService.showCallback(ErrorCallback::class.java) else TODO()
        }
    }

    override fun showNoNetwork() {
        if (this::mLoadService.isInitialized){
            mLoadService.showCallback(NoNetworkCallback::class.java)
        }
    }

    /**
     * 解除视图与ViewModel的关联
     */
    override fun onDestroy() {
        super.onDestroy()
    }

    /**
     * 获取ViewModel
     */
    protected abstract fun getViewModel(): VM

    /**
     * 获取Binding的参数Variable
     */
    protected abstract fun getBindingVariable(): Int

    /**
     * 获取布局资源ID
     */
    @LayoutRes
    protected abstract fun getLayoutId(): Int

    /**
     * 失败重试,重新加载事件
     */
    protected abstract fun onRetryBtnClick()

}