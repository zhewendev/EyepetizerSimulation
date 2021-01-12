package com.zhewen.eyepetizer_common.util.device

import android.R
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.*
import android.view.ViewGroup.MarginLayoutParams
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.annotation.ColorInt
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
                        window.insetsController?.show(WindowInsets.Type.statusBars())
                    } else {
                        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                        showStatusBarView(window)
                        addMarginTopEqualStatusBarHeight(window)
                    }
                }
                false -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        window.insetsController?.hide(WindowInsets.Type.statusBars())
                    } else {
                        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                        hideStatusBarView(window)
                        subtractMarginTopEqualStatusBarHeight(window)
                    }
                }
            }
        }

        /**
         * 返回状态栏是否可见
         */
        // TODO: 2021/1/5  
        fun isStatusBarVisible(activity: Activity, view: View): Boolean {

            val flags = activity.window.attributes.flags
            return (flags and WindowManager.LayoutParams.FLAG_FULLSCREEN) == 0
        }

        /**
         * 设置状态栏的light模式
         */
        fun setStatusBarLightMode(
            @NonNull activity: Activity,
            isLightMode: Boolean
        ) {
            setStatusBarLightMode(activity.window, isLightMode)
        }

        /**
         * 设置状态栏是否为浅色模式
         */
        fun setStatusBarLightMode(window: Window, isLightMode: Boolean) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                if (isLightMode) {
                    window.insetsController?.setSystemBarsAppearance(
                        APPEARANCE_LIGHT_STATUS_BARS,
                        APPEARANCE_LIGHT_STATUS_BARS
                    )
                } else {
                    window.insetsController?.setSystemBarsAppearance(0, 0)
                }
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val decorView = window.decorView
                var vis = decorView.systemUiVisibility
                vis = if (isLightMode) {
                    vis or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                } else {
                    vis and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                }
                decorView.systemUiVisibility = vis
            }
        }

        /**
         * 判断状态栏是否为浅色模式
         */
        fun isStatusBarLightMode(activity: Activity):Boolean{
            return isStatusBarLightMode(activity.window)
        }

        /**
         * 判断状态栏是否为浅色模式
         */
        fun isStatusBarLightMode(window: Window): Boolean{

            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.insetsController?.systemBarsAppearance == APPEARANCE_LIGHT_STATUS_BARS
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val decorView = window.decorView
                val vis = decorView.systemUiVisibility
                vis and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR != 0
            } else {
                false
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

        /**
         * 设置状态栏的颜色
         */
        fun setStatusBarColor(activity: Activity, color: Int):View? {
            return setStatusBarColor(activity, color, false)
        }

        /**
         * 设置状态栏颜色
         * @param isDecor true 表示在Decorview中添加虚假状态栏，fasle则表示添加在contentview
         */
        fun setStatusBarColor(activity: Activity, color: Int, isDecor: Boolean):View?{
            transparentStatusBar(activity)
            return applyStatusBarColor(activity, color, isDecor)
        }

        /**
         * 设置状态栏颜色
         */
        fun setStatusBarColor(
            activity: Activity, @NonNull fakeStatusBar: View,
            @ColorInt color: Int
        ) {
            transparentStatusBar(activity)
            fakeStatusBar.visibility = View.VISIBLE
            val layoutParams = fakeStatusBar.layoutParams
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
            layoutParams.height = getStatusBarHeight()
            fakeStatusBar.setBackgroundColor(color)
        }

        /**
         * 设置自定义的状态栏
         */
        fun setStatusBarCustom(activity: Activity,@NonNull fakeStatusBar: View) {
            transparentStatusBar(activity)
            fakeStatusBar.visibility = View.VISIBLE
            var layoutParams = fakeStatusBar.layoutParams
            if (layoutParams == null) {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    getStatusBarHeight()
                )
                fakeStatusBar.layoutParams = layoutParams
            } else {
                layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
                layoutParams.height = getStatusBarHeight()
            }
        }

        private fun createStatusBarView(
            context: Context,
            color: Int
        ): View {
            val statusBarView = View(context)
            statusBarView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                getStatusBarHeight()
            )
            statusBarView.setBackgroundColor(color)
            statusBarView.tag =TAG_STATUS_BAR
            return statusBarView
        }

        /**
         * 实现透明系统状态栏
         */
        private fun transparentStatusBar(activity: Activity) {
            transparentStatusBar(activity.window)
        }

        /**
         * 实现透明系统状态栏
         */
        private fun transparentStatusBar(window: Window) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.setDecorFitsSystemWindows(false)
            } else {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                val option =
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                val vis = window.decorView.systemUiVisibility
                window.decorView.systemUiVisibility = option or vis
                window.statusBarColor = Color.TRANSPARENT
            }
        }

        private fun applyStatusBarColor(
            activity: Activity,
            color: Int,
            isDecor: Boolean
        ): View {
            return applyStatusBarColor(activity.window, color, isDecor)
        }

        private fun applyStatusBarColor(
            window: Window,
            color: Int,
            isDecor: Boolean
        ): View {
            val parent =
                if (isDecor) window.decorView as ViewGroup else (window.findViewById<View>(R.id.content) as ViewGroup)
            var fakeStatusBarView =
                parent.findViewWithTag<View>(TAG_STATUS_BAR)
            if (fakeStatusBarView != null) {
                if (fakeStatusBarView.visibility == View.GONE) {
                    fakeStatusBarView.visibility = View.VISIBLE
                }
                fakeStatusBarView.setBackgroundColor(color)
            } else {
                fakeStatusBarView =
                    createStatusBarView(window.context, color)
                parent.addView(fakeStatusBarView)
            }
            return fakeStatusBarView
        }

    }


}