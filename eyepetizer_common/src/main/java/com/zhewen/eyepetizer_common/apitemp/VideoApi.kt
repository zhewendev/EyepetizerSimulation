package com.zhewen.eyepetizer_common.apitemp

import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


//interface VideoApi {
//    @GET("api/v2/video/{videoId}")
//    fun requestSingleVideo(
//        @Path("videoId") j: Long,
//        @Query("resourceType") str: String?
//    ): Observable<VideoModel?>?
//
//    @FormUrlEncoded
//    @POST("api/v3/share/shareNotify")
//    fun shareNotify(
//        @Field("sourceType") i: Int,
//        @Field("videoId") j: Long,
//        @Field("result") i2: Int
//    ): Observable<ApiResult?>?
//}