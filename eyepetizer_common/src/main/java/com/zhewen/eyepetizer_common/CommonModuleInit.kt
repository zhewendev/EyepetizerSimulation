package com.zhewen.eyepetizer_common

import com.zhewen.eyepetizer_base.base.BaseApplication
import com.zhewen.eyepetizer_base.config.IModuleInit

/**
 * Common库自身初始化操作
 */
class CommonModuleInit:IModuleInit {

    override fun onInitAhead(application: BaseApplication): Boolean {
        return false
    }

    override fun onInitEnd(application: BaseApplication): Boolean {
        return false
    }
}