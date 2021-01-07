package com.zhewen.eyepetizer_base.config

import com.zhewen.eyepetizer_base.base.BaseApplication

/**
 * 动态配置组件Application,有需要初始化的组件实现该接口,统一在宿主app 的Application进行初始化
 */
interface IModuleInit {

    /**
     * 需要优先初始化
     */
    fun onInitAhead(application: BaseApplication):Boolean

    /**
     * 可以后初始化
     */
    fun onInitEnd(application: BaseApplication):Boolean
}