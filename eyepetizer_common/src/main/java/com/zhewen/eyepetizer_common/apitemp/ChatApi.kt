package com.zhewen.eyepetizer_common.apitemp

import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

//
//interface ChatApi {
//    @FormUrlEncoded
//    @POST("api/telephone/friend")
//    fun contactFriend(@Field("telephoneNameList") str: String?): Observable<ApiResult?>?
//
//    @FormUrlEncoded
//    @POST("api/v2/private/message/sendPrivateMsg")
//    fun sendMsg(
//        @Field("anotherUid") str: String?,
//        @Field("content") str2: String?,
//        @Field("type") str3: String?
//    ): Observable<MsgSendResult?>?
//
//    @FormUrlEncoded
//    @POST("api/v2/private/message/sendPrivateMsg")
//    fun sendMsg(
//        @Field("anotherUid") str: String?,
//        @Field("content") str2: String?,
//        @Field("type") str3: String?,
//        @Field("privateMessageId") str4: String?
//    ): Observable<MsgSendResult?>?
//}