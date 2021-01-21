package com.zhewen.eyepetizer_home.data.model

import com.zhewen.eyepetizer_common.data.model.Item

data class DiscoveryModel(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<Item>,
    val nextPageUrl: Any,
    val total: Int
)