package com.zhewen.eyepetizer_common.apitemp

import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


//interface CardApi {
//    @FormUrlEncoded
//    @POST("v1/content/item/collect_item")
//    fun doCollectItem(
//        @Field("resource_id") str: String?,
//        @Field("resource_type") str2: String?
//    ): Observable<Any?>?
//
//    @FormUrlEncoded
//    @POST("v1/content/item/follow")
//    fun doFollow(
//        @Field("resource_id") str: String?,
//        @Field("resource_type") str2: String?
//    ): Observable<Any?>?
//
//    @FormUrlEncoded
//    @POST("v1/content/item/like_item")
//    fun doLikeItem(
//        @Field("resource_id") str: String?,
//        @Field("resource_type") str2: String?
//    ): Observable<Any?>?
//
//    @FormUrlEncoded
//    @POST("v1/content/item/cancel_collect_item")
//    fun doUncollectItem(
//        @Field("resource_id") str: String?,
//        @Field("resource_type") str2: String?
//    ): Observable<Any?>?
//
//    @FormUrlEncoded
//    @POST("v1/content/item/cancel_follow")
//    fun doUnfollow(
//        @Field("resource_id") str: String?,
//        @Field("resource_type") str2: String?
//    ): Observable<Any?>?
//
//    @FormUrlEncoded
//    @POST("v1/content/item/cancel_like_item")
//    fun doUnlikeItem(
//        @Field("resource_id") str: String?,
//        @Field("resource_type") str2: String?
//    ): Observable<Any?>?
//
//    @FormUrlEncoded
//    @POST("v1/card/page/get_nav")
//    fun getNav(@Field("tab_label") str: String?): Observable<Any?>?
//}