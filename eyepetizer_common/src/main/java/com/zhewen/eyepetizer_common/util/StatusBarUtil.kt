package com.zhewen.eyepetizer_common.util

import android.app.Activity
import android.os.Build
import android.view.*
import android.view.ViewGroup.MarginLayoutParams
import androidx.annotation.NonNull
import com.zhewen.eyepetizer_base.base.BaseApplication


/**
 * 状态栏工具
 */
class StatusBarUtil {

    companion object {
        private const val TAG_STATUS_BAR: String = "TAG_STATUS_BAR"
        private const val TAG_OFFSET: String = "TAG_OFFSET"
        const val DEFAULT_STATUS_BAR_ALPHA = 112
        private const val TAG_KEY_HAVE_SET_OFFSET = -123

        /**
         * 返回状态栏高度
         */
        fun getStatusBarHeight(): Int {
            val resources = BaseApplication.getInstance().resources
            val resourcesId = resources.getIdentifier("status_bar_height", "dimen", "android")
            return resources.getDimensionPixelSize(resourcesId)
        }

        /**
         * 设置状态栏可见性
         */
        fun setStatusBarVisibility(activity: Activity, isVisible: Boolean) {
            setStatusBarVisibility(activity.window, isVisible)
        }

        /**
         * 设置状态栏可见性
         */
        fun setStatusBarVisibility(window: Window, isVisible: Boolean) {
            when (isVisible) {
                true -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        window.insetsController?.show(WindowInsets.Type.systemBars())
                    } else {
                        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                    }
                    showStatusBarView(window)
                    addMarginTopEqualStatusBarHeight(window)
                }
                false -> {
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
                        window.insetsController?.hide(WindowInsets.Type.systemBars())
                    } else {
                        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                    }
                    hideStatusBarView(window)
                    subtractMarginTopEqualStatusBarHeight(window)
                }
            }
        }

        /**
         * 返回状态栏是否可见
         */
        // TODO: 2021/1/4  
        fun isStatusBarVisible(activity: Activity): Boolean {
            val flags = activity.window.attributes.flags
            return when (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
                true -> (flags and WindowManager.LayoutParams.FLAG_FULLSCREEN) == 0
                false -> {
                    activity.window.decorView.setOnApplyWindowInsetsListener(object : View.OnApplyWindowInsetsListener{
                        override fun onApplyWindowInsets(
                            v: View?,
                            insets: WindowInsets?
                        ): WindowInsets? {
                            return insets
                        }
                    })
                }

            }
        }

        fun hideStatusBarView(window: Window) {
            val decorView = window.decorView as ViewGroup
            val fakeStatusBarView =
                decorView.findViewWithTag<View>(TAG_STATUS_BAR)
                    ?: return
            fakeStatusBarView.visibility = View.GONE
        }


        fun showStatusBarView(window: Window) {
            val decorView = window.decorView as ViewGroup
            val fakeStatusBarView = decorView.findViewWithTag<View>(TAG_STATUS_BAR) ?: return
            fakeStatusBarView.visibility = View.VISIBLE
        }


        fun addMarginTopEqualStatusBarHeight(window: Window) {
            val withTag = window.decorView.findViewWithTag<View>(TAG_STATUS_BAR) ?: return
            addMarginTopEqualStatusBarHeight(withTag)
        }

        fun subtractMarginTopEqualStatusBarHeight(window: Window) {
            val withTag =
                window.decorView.findViewWithTag<View>(TAG_OFFSET)
                    ?: return
            subtractMarginTopEqualStatusBarHeight(withTag)
        }

        /**
         * 为view减去顶部状态栏的高度
         */
        fun subtractMarginTopEqualStatusBarHeight(@NonNull view: View) {
            val haveSetOffset = view.getTag(TAG_KEY_HAVE_SET_OFFSET)
            if (haveSetOffset == null || !(haveSetOffset as Boolean)) return
            val layoutParams = view.layoutParams as MarginLayoutParams
            layoutParams.setMargins(
                layoutParams.leftMargin,
                layoutParams.topMargin - getStatusBarHeight(),
                layoutParams.rightMargin,
                layoutParams.bottomMargin
            )
            view.setTag(TAG_KEY_HAVE_SET_OFFSET, false)
        }

        /**
         * 为view添加顶部状态栏的高度
         */
        fun addMarginTopEqualStatusBarHeight(view: View) {
            view.tag = TAG_OFFSET
            val haveSetOffset = view.getTag(TAG_KEY_HAVE_SET_OFFSET)
            if (haveSetOffset != null && !(haveSetOffset as Boolean)) return
            val layoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
            layoutParams.setMargins(
                layoutParams.leftMargin, layoutParams.topMargin + getStatusBarHeight(),
                layoutParams.rightMargin, layoutParams.bottomMargin
            )
            view.setTag(TAG_KEY_HAVE_SET_OFFSET, true)
        }

    }


}