//package com.zhewen.eyepetizer_common.apitemp
//
//import retrofit2.http.FormUrlEncoded
//import retrofit2.http.POST
//
//
//interface AuthApi {
//    @FormUrlEncoded
//    @POST("v1/system/auth/token")
//    fun getToken(
//        @Field("device_info") str: String?,
//        @Field("grant_type") str2: String?,
//        @Field("sign") str3: String?,
//        @Field("ts") str4: String?,
//        @Field("refresh_token") str5: String?
//    ): Observable<Any?>?
//
//    @FormUrlEncoded
//    @POST("v1/system/auth/token")
//    fun getTokenSync(
//        @Field("device_info") str: String?,
//        @Field("grant_type") str2: String?,
//        @Field("sign") str3: String?,
//        @Field("ts") str4: String?,
//        @Field("refresh_token") str5: String?
//    ): Call<Any?>?
//
//    @FormUrlEncoded
//    @POST("/v1/user/push/save_push_info")
//    fun savePushInfo(
//        @Field("client_id") str: String?,
//        @Field("push_platform") str2: String?
//    ): Observable<Any?>?
//}