package com.zhewen.eyepetizer_notification.data.remote

import retrofit2.http.GET

interface NotificationService {
    @GET("api/v7/tag/tabList")
    suspend fun fetchNotificationThemePage()

    @GET("api/v3/messages")
    suspend fun fetchNotificationMessagePage()

    @GET("api/v7/topic/list")
    suspend fun fetchNotificationInteractPage()
}