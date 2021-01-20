package com.zhewen.eyepetizer_common.apitemp

import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


//interface NormalAccountApi {
//    @FormUrlEncoded
//    @POST("v1/api/bindPhone")
//    fun bindPhone(
//        @Field("telephone") str: String?,
//        @Field("code") str2: String?,
//        @Field("uid") str3: String?
//    ): Observable<AccountApiResult?>?
//
//    @FormUrlEncoded
//    @POST("v1/api/login")
//    fun normalLogin(
//        @Field("username") str: String?,
//        @Field("password") str2: String?
//    ): Observable<AccountResponse?>?
//
//    @FormUrlEncoded
//    @POST("v2/api/register")
//    fun normalRegister(
//        @Field("username") str: String?,
//        @Field("password") str2: String?,
//        @Field("code") str3: String?
//    ): Observable<AccountResponse?>?
//
//    @FormUrlEncoded
//    @POST("v1/api/sms/initialization")
//    fun requestVerifyCode(
//        @Field("type") str: String?,
//        @Field("telephone") str2: String?
//    ): Observable<AccountApiResult?>?
//}