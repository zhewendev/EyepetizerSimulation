package com.zhewen.eyepetizer_base.config

/**
 * 组件生命周期初始化类的类目管理者,在这里注册需要初始化的组件,通过反射动态调用各个组件的初始化方法
 */
class ModuleLifecycleReflex {

    companion object {
        /**
         * Base库
         */
        private const val BASE_INIT = "com.zhewen.eyepetizer_base.BaseModuleInit"

        /**
         * Common库
         */
        private const val COMMON_INIT = "com.zhewen.eyepetizer_common.CommonModuleInit"

        /**
         * Home库
         */
        const val HOME_INIT = "com.zhewen.eyepetizer_home_HomeModuleInit"

        val mInitModuleNames = arrayOf(BASE_INIT, COMMON_INIT)
    }
}