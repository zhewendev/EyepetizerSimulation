package com.zhewen.eyepetizer_common.apitemp

import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url


//interface ShieldApi {
//    @FormUrlEncoded
//    @POST("api/v4/shield/add")
//    fun addShield(@Field("itemType") str: String?, @Field("itemId") i: Int): Observable<ApiResult?>?
//
//    @FormUrlEncoded
//    @POST("api/v1/follow/cancel")
//    fun cancelFollow(
//        @Field("itemType") str: String?,
//        @Field("itemId") i: Int
//    ): Observable<ApiResult?>?
//
//    @FormUrlEncoded
//    @POST("api/v4/shield/cancel")
//    fun cancelShield(
//        @Field("itemType") str: String?,
//        @Field("itemId") i: Int
//    ): Observable<ApiResult?>?
//
//    @GET("api/v2/notification/switchClick")
//    fun changeSwitcherStatus(
//        @Query("uid") str: String?,
//        @Query("notificationType") str2: String?,
//        @Query("switchStatus") z: Boolean,
//        @Query("itemId") i: Int
//    ): Observable<ApiResult?>?
//
//    @FormUrlEncoded
//    @POST("api/v2/private/message/deleteConversation")
//    fun deleteConversation(
//        @Field("privateMessageId") str: String?,
//        @Field("anotherUid") str2: String?
//    ): Observable<ApiResult?>?
//
//    @FormUrlEncoded
//    @POST("api/v1/follow/add")
//    fun doFollow(@Field("itemType") str: String?, @Field("itemId") i: Int): Observable<ApiResult?>?
//
//    @GET("api/v4/shield/status")
//    fun getForbidStatus(@Query("itemId") str: String?): Observable<ForbidStatusResult?>?
//
//    @GET("api/v2/notification/switchPage")
//    fun getSwitcher(@Query("uid") str: String?): Observable<FollowPageBean?>?
//
//    @FormUrlEncoded
//    @POST("api/v4/hateVideo/add")
//    fun hateVideo(
//        @Field("reason") i: Int,
//        @Field("videoId") i2: Int,
//        @Field("tagId") i3: Int
//    ): Observable<ApiResult?>?
//
//    @GET
//    fun queryMoreShieldUserList(@Url str: String?): Observable<GetShiedListResult?>?
//
//    @GET("api/v4/shield/list")
//    fun queryShieldUserList(
//        @Query("itemType") str: String?,
//        @Query("num") i: Int
//    ): Observable<GetShiedListResult?>?
//}