package com.zhewen.eyepetizer_base.base

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.zhewen.eyepetizer_base.BuildConfig
import kotlin.properties.Delegates

/**
 * Application基类
 */
open class BaseApplication : MultiDexApplication() {

    companion object {
        private const val TAG = "EyepetizerApplication"
        private var sInstance: BaseApplication by Delegates.notNull()
        private var sDebug: Boolean by Delegates.notNull()

        /**
         * 获取当前进程名
         */
        fun getCurrentProcessName(context: Context):String? {
            val am = context.getSystemService(ACTIVITY_SERVICE) as? ActivityManager
            val runningApps = am?.runningAppProcesses ?: return null

            for (proInfo: ActivityManager.RunningAppProcessInfo in runningApps) {
                if (proInfo.pid == android.os.Process.myPid() && proInfo.processName != null) {
                    return proInfo.processName
                }
            }
            return null
        }

        /**
         * 获取applicaton
         */
        fun getInstance():BaseApplication{
            return sInstance
        }

        fun setsDebug(debug: Boolean){
            sDebug = debug
        }

        fun getIsDebug():Boolean {
            return sDebug
        }
    }

    override fun onCreate() {
        super.onCreate()
        registerActivityLifeCycle(this)
        initLogConfig()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    /**
     * 初始化Application，监听app生命周期回调
     */
    private fun registerActivityLifeCycle(application: BaseApplication) {
        sInstance = application
        application.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                ActivityStackManager.sActivityStackManagerInstance.addActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityResumed(activity: Activity) {
            }

            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityDestroyed(activity: Activity) {
                ActivityStackManager.sActivityStackManagerInstance.removeActivity(activity)
            }
        })
    }

    private fun initLogConfig() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)  // 隐藏线程信息 默认：显示
            .methodCount(0)         // 决定打印多少行（每一行代表一个方法）默认：2
            .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
            .tag(TAG)   // (Optional) Global tag for every log. Default PRETTY_LOGGER
            .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }

}