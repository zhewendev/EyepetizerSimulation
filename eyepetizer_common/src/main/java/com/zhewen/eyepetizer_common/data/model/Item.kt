package com.zhewen.eyepetizer_common.data.model

data class Item(
    val adIndex: Int,
    val `data`: Data,
    val id: Int,
    val tag: Any?,
    val trackingData: Any?,
    val type: String
)