package com.zhewen.eyepetizer_common.util.font

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.zhewen.eyepetizer_common.R

/**
 * 自定义TextView的字体
 */
class CustomFontText(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) :
    AppCompatTextView(
        context, attributeSet,defStyleAttr) {

    constructor(context: Context):this(context,null,0)

    constructor(context: Context, attributeSet: AttributeSet) : this(context, attributeSet, 0)

    init {
        val ta = context.obtainStyledAttributes(attributeSet, R.styleable.CustomFontText)
        val fontTypefaceName = ta.getString(R.styleable.CustomFontText_fontTypeface)
        initConfig(fontTypefaceName)
        ta.recycle()
    }

    private fun initConfig(fontTypefaceName:String?) {
        val fontTypeface = fontTypefaceName?.let { FontCache.getCustomTypeFace(it) }
        typeface = fontTypeface
    }
}