package com.zhewen.eyepetizer_base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.zhewen.eyepetizer_base.activity.IBaseView
import com.zhewen.eyepetizer_base.loadsir.EmptyCallback
import com.zhewen.eyepetizer_base.loadsir.ErrorCallback
import com.zhewen.eyepetizer_base.loadsir.LoadingCallback
import com.zhewen.eyepetizer_base.loadsir.NoNetworkCallback
import com.zhewen.eyepetizer_base.viewmodel.IBaseViewModel

/**
 * 懒加载的Fragment基类
 */
abstract class LazyMvvmFragment<V : ViewDataBinding,VM : IBaseViewModel>: Fragment(),IBaseView {

    protected var mFragmentTag:String = this.javaClass.simpleName
    lateinit var mViewDataBinding:V
    lateinit var mViewModel:VM
    lateinit var mLoadService: LoadService<Any>

    protected lateinit var mRootView:View

    protected var mIsLoaded : Boolean= false //数据是否初始化过

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initParameters()
    }

    /**
     * 初始化参数
     */
    protected fun initParameters(){

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!this::mRootView.isInitialized){
            mViewDataBinding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false)
            mRootView = mViewDataBinding.root
        }
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = getViewModel()
        if (getBindingVariable() > 0) {
            mViewDataBinding.setVariable(getBindingVariable(),mViewModel)
            mViewDataBinding.executePendingBindings()
        }
    }

    override fun onResume() {
        super.onResume()
        //增加Fragment是否可见的判断
        if (!mIsLoaded && !isHidden) {
            lazyInit()
            mIsLoaded = true
        }
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

    override fun onDestroyView() {
        super.onDestroyView()
        mIsLoaded = false
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

    /**
     * 数据延迟初始化
     */
    protected abstract fun lazyInit()

}