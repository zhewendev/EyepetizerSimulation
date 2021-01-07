package com.zhewen.eyepetizer_base.config

import com.zhewen.eyepetizer_base.base.BaseApplication

/**
 * 作为组件生命周期初始化的配置类,通过反射机制,动态调用每个组件初始化逻辑
 */
class ModuleLifecycleConfig private constructor(){

    companion object{
        fun getInstance() : ModuleLifecycleConfig {
            return SingleHolder.instance
        }
    }

    private object SingleHolder{
        val instance = ModuleLifecycleConfig()
    }

    /**
     * 优先初始化
     */
    fun initModuleAhead(application: BaseApplication) {
        for (moduleName in ModuleLifecycleReflex.mInitModuleNames) {
            try {
                val clazz = Class.forName(moduleName)
                val init = clazz.newInstance() as IModuleInit
                init.onInitAhead(application)   //调用初始化方法
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
        }
    }

    /**
     * 可以后初始化
     */
    fun initModuleEnd(application: BaseApplication) {
        for (moduleName in ModuleLifecycleReflex.mInitModuleNames) {
            try {
                val clazz = Class.forName(moduleName)
                val init = clazz.newInstance() as IModuleInit
                init.onInitEnd(application) //调用初始化方法
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
        }
    }
}