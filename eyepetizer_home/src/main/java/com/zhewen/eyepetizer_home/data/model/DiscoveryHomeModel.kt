package com.zhewen.eyepetizer_home.data.model

data class DiscoveryHomeModel(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<Item>,
    val nextPageUrl: Any,
    val total: Int
)