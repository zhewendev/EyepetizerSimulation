package com.zhewen.eyepetizer_base.loadsir

import android.content.Context
import android.view.View
import com.kingja.loadsir.callback.Callback

class NoNetworkCallback : Callback() {

    /**
     * 填充布局
     */
    override fun onCreateView(): Int {
        TODO("Not yet implemented")
    }

    /**
     *当前Callback的点击事件，如果返回true则覆盖注册时的onReload()，如果返回false则两者都执行，先执行onReloadEvent()
     */
    override fun onReloadEvent(context: Context?, view: View?): Boolean {
        return super.onReloadEvent(context, view)
        // TODO: 2020/12/24
    }

    /**
     * 是否在显示Callback视图的时候显示原始图(SuccessView)，返回true显示，false隐藏
     */
    override fun getSuccessVisible(): Boolean {
        return super.getSuccessVisible()
        // TODO: 2020/12/24
    }
}