package com.zhewen.eyepetizer_common.util.device

import android.app.Activity
import android.content.res.Resources
import android.os.Build
import android.view.*
import androidx.annotation.NonNull
import com.zhewen.eyepetizer_base.base.BaseApplication

/**
 * 底部导航栏工具类
 */
class NavigationBarUntil {

    companion object {
        /**
         * 获取底部导航栏高度
         */
        fun getNavBarHeight(): Int {
            val res: Resources = BaseApplication.getInstance().resources
            val resourceId = res.getIdentifier("navigation_bar_height", "dimen", "android")
            return if (resourceId != 0) {
                res.getDimensionPixelSize(resourceId)
            } else {
                0
            }
        }

        /**
         * 设置底部导航栏的可见性
         */
        fun setNavBarVisibility(@NonNull activity: Activity, isVisible: Boolean) {
            setNavBarVisibility(activity.window, isVisible)
        }

        /**
         * 设置底部导航栏的可见性
         */
        fun setNavBarVisibility(@NonNull window: Window, isVisible: Boolean) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                if (isVisible) {
                    window.insetsController?.show(WindowInsets.Type.navigationBars())
                } else {
                    window.insetsController?.hide(WindowInsets.Type.navigationBars())
                }
            } else {
                val decorView = window.decorView as ViewGroup
                var i = 0
                val count = decorView.childCount
                while (i < count) {
                    val child = decorView.getChildAt(i)
                    val id = child.id
                    if (id != View.NO_ID) {
                        val resourceEntryName: String = getResNameById(id)
                        if ("navigationBarBackground" == resourceEntryName) {
                            child.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
                        }
                    }
                    i++
                }
                val uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
                if (isVisible) {
                    decorView.systemUiVisibility = decorView.systemUiVisibility and uiOptions.inv()
                } else {
                    decorView.systemUiVisibility = decorView.systemUiVisibility or uiOptions
                }
            }
        }

        private fun getResNameById(id: Int): String {

            return try {
                BaseApplication.getInstance().resources.getResourceEntryName(id)
            } catch (e: Exception) {
                e.printStackTrace()
                ""
            }
        }

        /**
         * 设置导航栏的颜色
         */
        fun setNavBarColor(activity: Activity, color: Int) {
            setNavBarColor(activity.window, color)
        }

        /**
         * 设置导航栏颜色
         */
        fun setNavBarColor(window: Window, color: Int) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.navigationBarColor = color
        }

        /**
         * 获取导航栏颜色
         */
        fun getNavBarColor(activity: Activity):Int {
            return getNavBarColor(activity.window)
        }

        /**
         * 获取导航栏颜色
         */
        fun getNavBarColor(window: Window):Int {
            return window.navigationBarColor
        }
    }


}