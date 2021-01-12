package com.zhewen.eyepetizersimulation.ui

import android.Manifest
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.orhanobut.logger.Logger
import com.zhewen.eyepetizer_base.activity.BaseMvvmActivity
import com.zhewen.eyepetizer_base.base.ActivityStackManager
import com.zhewen.eyepetizer_base.util.MMKVPreference
import com.zhewen.eyepetizer_common.util.device.StatusBarUtil
import com.zhewen.eyepetizersimulation.R
import com.zhewen.eyepetizersimulation.databinding.ActivityLandingBinding
import com.zhewen.eyepetizersimulation.utils.Constants
import pub.devrel.easypermissions.EasyPermissions
import kotlin.properties.Delegates

/**
 * 启动页
 */
class LandingActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {

    private var mIsFirstEnter by MMKVPreference(Constants.KEY_IS_FIRST_OPEN_APP, true)
    private lateinit var mViewBinding: ActivityLandingBinding
    private var alphaAnimation: AlphaAnimation by Delegates.notNull()

    companion object {
        private const val TAG: String = "LandingActivity"
        private const val REQUEST_PERMISSION_CODE = 111
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)
        initConfig()
        initAnimation()
    }

    private fun initConfig() {
        StatusBarUtil.setStatusBarLightMode(this, true)
        StatusBarUtil.setStatusBarVisibility(this, false)
        StatusBarUtil.setStatusBarColor(this, Color.TRANSPARENT)
    }

    private fun initAnimation() {
        alphaAnimation = AlphaAnimation(0.3f, 1.0f)
        alphaAnimation.duration = 1000
        alphaAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                checkPermission()   //检查权限
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })
    }

    /**
     * 页面跳转，根据是否是首次打开app，跳转不同的页面
     */
    private fun pageJump(){
        //首次进入，展示新手引导页
        if (mIsFirstEnter) {
            mViewBinding.fragmentContainerView.visibility = View.VISIBLE
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<WelcomePageFragment>(R.id.fragment_container_view)
            }
            Logger.d(TAG, "首次进入")
        } else {
            //进入到主页面
            Logger.d(TAG, "进入主页面")
        }
    }

    //检查权限
    private fun checkPermission() {
        if (!hasAllPermissionGrant()) {
            ActivityCompat.requestPermissions(
                this,
                permissionRequest(),
                REQUEST_PERMISSION_CODE
            )
        } else {
            pageJump()
        }
    }

    /**
     * 权限是否都已获取
     */
    private fun hasAllPermissionGrant(): Boolean {
        for (permission in permissionRequest()) {
            if (!EasyPermissions.hasPermissions(this, permission)) {
                return false
            }
        }
        return true
    }

    /**
     * 需要申请的权限列表
     */
    private fun permissionRequest(): Array<String> {
        return arrayOf(
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    }

    /**
     * 权限申请回调
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (hasAllPermissionGrant()) {
            //权限全部申请到，进入欢迎引导页
            pageJump()
        }
        EasyPermissions.onRequestPermissionsResult(
            REQUEST_PERMISSION_CODE,
            permissions,
            grantResults,
            this
        )
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        Logger.t(TAG).d("onPermissionDenied，申请权限失败的有$perms")
    }

    /**
     * 权限申请成功回调
     */
    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {

        Logger.t(TAG).d("onPermissionGranted, 获取成功的权限$perms")
    }


    override fun onStart() {
        super.onStart()
        ActivityStackManager.sActivityStackManagerInstance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityStackManager.sActivityStackManagerInstance.removeActivity(this)
    }
}