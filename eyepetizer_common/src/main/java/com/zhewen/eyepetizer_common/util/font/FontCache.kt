package com.zhewen.eyepetizer_common.util.font

import android.graphics.Typeface
import com.zhewen.eyepetizer_base.base.BaseApplication

/**
 * 自定义的字体缓存
 */
class FontCache {

    companion object{
        private val mFontCache:HashMap<String,Typeface?> = HashMap()

        /**
         * 获取自定义的字体类型
         */
        fun getCustomTypeFace(fontTypefaceName:String):Typeface?{

            val typefacePath = "fonts/${fontTypefaceName}.ttf"
            var typeface= mFontCache[fontTypefaceName]
            if (typeface == null) {
                try {
                    typeface = Typeface.createFromAsset(BaseApplication.getInstance().assets,typefacePath)
                } catch (e:Exception) {
                    e.printStackTrace()
                }
                mFontCache[fontTypefaceName] = typeface
            }
            return typeface
        }
    }

}