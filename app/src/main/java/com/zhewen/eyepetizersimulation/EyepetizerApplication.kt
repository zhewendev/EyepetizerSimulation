package com.zhewen.eyepetizersimulation

import com.zhewen.eyepetizer_base.base.BaseApplication
import com.zhewen.eyepetizer_base.config.ModuleLifecycleConfig
import dagger.hilt.android.HiltAndroidApp

/**
 *
 */
@HiltAndroidApp
class EyepetizerApplication:BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        setsDebug(BuildConfig.DEBUG)
        ModuleLifecycleConfig.getInstance().initModuleAhead(this)
        ModuleLifecycleConfig.getInstance().initModuleEnd(this)
    }
}