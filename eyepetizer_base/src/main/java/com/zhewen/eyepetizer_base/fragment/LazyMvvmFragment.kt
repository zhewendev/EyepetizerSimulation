package com.zhewen.eyepetizer_base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.orhanobut.logger.Logger
import com.zhewen.eyepetizer_base.activity.IBaseView
import com.zhewen.eyepetizer_base.loadsir.EmptyCallback
import com.zhewen.eyepetizer_base.loadsir.ErrorCallback
import com.zhewen.eyepetizer_base.loadsir.LoadingCallback
import com.zhewen.eyepetizer_base.loadsir.NoNetworkCallback
import com.zhewen.eyepetizer_base.viewmodel.IBaseViewModel
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

/**
 * 懒加载的Fragment基类
 */
abstract class LazyMvvmFragment<V : ViewDataBinding,VM : IBaseViewModel>: Fragment(),IBaseView,EasyPermissions.PermissionCallbacks {

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
     * 权限结果回调，接收权限请求结果
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)    //将权限请求结果传递给EasyPermission库处理
    }

    /**
     * 权限申请失败回调
     */
    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        // 处理权限名字字符串
        val sb = StringBuffer()
        for (str in perms) {
            sb.append(str)
            sb.append("\n")
        }
        sb.replace(sb.length - 2, sb.length, "")
        //用户点击拒绝并不再询问时调用
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            Toast.makeText(activity, "已拒绝权限" + sb + "并不再询问", Toast.LENGTH_SHORT).show()
            AppSettingsDialog.Builder(this)
                .setRationale("此功能需要" + sb + "权限，否则无法正常使用，是否打开设置")
                .setPositiveButton("是")
                .setNegativeButton("否")
                .build()
                .show()
        }
    }

    /**
     * 权限申请成功回调
     */
    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {

        Logger.t(TAG).d("onPermissionGranted, 获取成功的权限$perms")

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

    companion object{
        const val TAG = "LazyMvvmFragment"
    }

}