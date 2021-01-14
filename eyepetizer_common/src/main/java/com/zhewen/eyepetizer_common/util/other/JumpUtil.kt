package com.zhewen.eyepetizer_common.util.other

import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter

/**
 * 跳转工具类
 */
class JumpUtil {

    companion object{
        /**
         * ARouter 本地页面跳转
         */
        fun jumpToNative(url:String,isGreen:Boolean,params:MutableMap<String,String>){
            val postCard = ARouter.getInstance().build(url)
            for ((key,value) in params) {
                postCard.withString(key,value)
            }
            if (isGreen) {
                postCard.greenChannel()
            }
            postCard.navigation()
        }
    }
}