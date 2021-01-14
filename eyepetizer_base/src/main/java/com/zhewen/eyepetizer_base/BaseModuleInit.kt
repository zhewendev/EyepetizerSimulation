package com.zhewen.eyepetizer_base

import com.alibaba.android.arouter.launcher.ARouter
import com.kingja.loadsir.core.LoadSir
import com.orhanobut.logger.Logger
import com.tencent.mmkv.MMKV
import com.zhewen.eyepetizer_base.base.BaseApplication
import com.zhewen.eyepetizer_base.config.IModuleInit
import com.zhewen.eyepetizer_base.loadsir.EmptyCallback
import com.zhewen.eyepetizer_base.loadsir.ErrorCallback
import com.zhewen.eyepetizer_base.loadsir.LoadingCallback
import com.zhewen.eyepetizer_base.loadsir.NoNetworkCallback

/**
 * Base库 初始化操作
 */
class BaseModuleInit: IModuleInit {

    override fun onInitAhead(application: BaseApplication): Boolean {
        MMKV.initialize(application)
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(application)
        LoadSir.beginBuilder()
            .addCallback(EmptyCallback())
            .addCallback(ErrorCallback())
            .addCallback(LoadingCallback())
            .addCallback(NoNetworkCallback())
            .setDefaultCallback(LoadingCallback::class.java)
            .commit()
        Logger.i("BaseModuleInit","BaseModuleInit success ---onInitAhead")
        return false
    }

    override fun onInitEnd(application: BaseApplication): Boolean {
        return false
    }
}