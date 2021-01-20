package com.zhewen.eyepetizer_home.data.remote

import retrofit2.http.GET

/**
 * Home部分的Api Service
 */
interface HomeService {

    @GET("api/v7/index/tab/discovery")  //发现更多
    suspend fun fetchDiscoveryPage()

    @GET("api/v5/index/tab/allRec")     //每日推荐
    suspend fun fetchDailyRecommendPage()

    @GET("api/v5/index/tab/feed")       //日报精选
    suspend fun fetchDailyFeedPage()

}