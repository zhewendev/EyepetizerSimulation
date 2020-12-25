package com.zhewen.eyepetizer_base.base

import android.app.Activity
import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.os.Bundle
import kotlin.properties.Delegates

/**
 * Application基类
 */
class BaseApplication : Application() {

    companion object {
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
    }

    override fun onCreate() {
        super.onCreate()
        registerActivityLifeCycle(this)
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