package com.zhewen.eyepetizer_community.data.remote

import retrofit2.http.GET

interface CommunityService {
    @GET("api/v7/community/tab/rec")
    suspend fun fetchCommunityRecommendedPage()

    @GET("api/v6/community/tab/follow")
    suspend fun fetchCommunityFollowPage()
}