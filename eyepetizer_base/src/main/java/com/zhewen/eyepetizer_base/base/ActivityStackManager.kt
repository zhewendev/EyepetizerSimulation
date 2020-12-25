package com.zhewen.eyepetizer_base.base

import android.app.Activity
import java.util.*

/**
 * Activity堆栈管理
 */
class ActivityStackManager private constructor() {

    companion object {
        val sActivityStackManagerInstance = SingletonHolder.holder
        private val mActivityStack: Stack<Activity> by lazy { Stack<Activity>() }
    }

    private object SingletonHolder {
        val holder = ActivityStackManager()
    }

    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity) {
        mActivityStack.add(activity)
    }

    /**
     * 将指定的activity从堆栈中移除
     */
    fun removeActivity(activity: Activity) {
        mActivityStack.remove(activity)
    }

    /**
     * 堆栈是否为空
     */
    fun isActivityStackEmpty(): Boolean {
        return mActivityStack.isEmpty()
    }

    /**
     * 获取栈顶activity
     */
    fun getCurrentActivity(): Activity? {
        return try {
            mActivityStack.lastElement()
        } catch (exception: NoSuchElementException) {
            null
        }

    }

    /**
     * 结束栈顶activity
     */
    fun finishActivity() {
        val activity = getCurrentActivity()
        if (activity != null) {
            finishActivity(activity)
        }
    }

    /**
     * 结束指定的activity
     */
    fun finishActivity(activity: Activity) {
        if (!activity.isFinishing) {
            activity.finish()
        }
    }

    /**
     * 结束指定类名的Activity
     */
    fun finishActivity(cls: Class<*>) {
        for (activity: Activity in mActivityStack) {
            if (activity.javaClass == cls) {
                finishActivity(activity)
                break
            }
        }
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        for (activity: Activity in mActivityStack) {
            finishActivity(activity)
        }
        mActivityStack.clear()
    }

    /**
     * 获取指定的Activity
     */
    fun getActivity(cls: Class<*>): Activity? {
        for (activity: Activity in mActivityStack) {
            if (activity.javaClass == cls) {
                return activity
            }
        }
        return null
    }
}