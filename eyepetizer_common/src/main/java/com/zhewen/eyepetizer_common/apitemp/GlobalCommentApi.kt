package com.zhewen.eyepetizer_common.apitemp

import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


//interface GlobalCommentApi {
//    @FormUrlEncoded
//    @POST("/v1/content/item/cancel_like_comment")
//    fun cancelLikeComment(@Field("comment_id") str: String?): Observable<ApiResult<OperateCommentBean?>?>?
//
//    @FormUrlEncoded
//    @POST("/v1/content/item/delete_comment")
//    fun deleteComment(@Field("comment_id") str: String?): Observable<ApiResult<OperateCommentBean?>?>?
//
//    @GET("v1/content/item/get_comment_list")
//    fun getCommentList(
//        @Query("uid") str: String?,
//        @Query("resource_id") str2: String?,
//        @Query("resource_type") str3: String?,
//        @Query("last_item_id") str4: String?,
//        @Query("item_per_page") i: Int
//    ): Observable<ApiResult<CommentBean?>?>?
//
//    @FormUrlEncoded
//    @POST("/v1/content/item/like_comment")
//    fun likeComment(@Field("comment_id") str: String?): Observable<ApiResult<OperateCommentBean?>?>?
//
//    @FormUrlEncoded
//    @POST("/v1/content/item/reply_comment")
//    fun replyComment(
//        @Field("resource_id") str: String?,
//        @Field("resource_type") str2: String?,
//        @Field("parent_id") str3: String?,
//        @Field("content") str4: String?
//    ): Observable<ApiResult<OperateCommentBean?>?>?
//
//    @FormUrlEncoded
//    @POST("/v1/content/item/report_comment")
//    fun reportComment(
//        @Field("comment_id") str: String?,
//        @Field("description") str2: String?
//    ): Observable<ApiResult<OperateCommentBean?>?>?
//
//    @FormUrlEncoded
//    @POST("/v1/content/item/add_comment")
//    fun sendComment(
//        @Field("resource_id") str: String?,
//        @Field("resource_type") str2: String?,
//        @Field("content") str3: String?
//    ): Observable<ApiResult<OperateCommentBean?>?>?
//}