package com.zhewen.eyepetizersimulation

import com.zhewen.eyepetizer_base.base.BaseApplication
import com.zhewen.eyepetizer_base.config.ModuleLifecycleConfig

class EyepetizerApplication:BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        setsDebug(BuildConfig.DEBUG)
        ModuleLifecycleConfig.getInstance().initModuleAhead(this)
        ModuleLifecycleConfig.getInstance().initModuleEnd(this)
    }
}