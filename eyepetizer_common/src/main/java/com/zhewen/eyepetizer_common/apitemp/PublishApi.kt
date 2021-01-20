package com.zhewen.eyepetizer_common.apitemp

import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


//interface PublishApi {
//    @FormUrlEncoded
//    @POST("api/upload/picture")
//    fun publishPicture(
//        @Field("description") str: String?,
//        @Field("tagList") str2: String?,
//        @Field("playUrl") str3: String?,
//        @Field("area") str4: String?,
//        @Field("city") str5: String?,
//        @Field("longitude") d: Double?,
//        @Field("latitude") d2: Double?,
//        @Field("width") i: Int,
//        @Field("height") i2: Int,
//        @Field("addWatermark") z: Boolean
//    ): Observable<PublishResult?>?
//
//    @FormUrlEncoded
//    @POST("api/upload/video")
//    fun publishVideo(
//        @Field("description") str: String?,
//        @Field("tagList") str2: String?,
//        @Field("duration") i: Int,
//        @Field("playUrl") str3: String?,
//        @Field("coverUrl") str4: String?,
//        @Field("area") str5: String?,
//        @Field("city") str6: String?,
//        @Field("longitude") d: Double?,
//        @Field("latitude") d2: Double?,
//        @Field("width") i2: Int,
//        @Field("height") i3: Int,
//        @Field("addWatermark") z: Boolean
//    ): Observable<PublishResult?>?
//
//    @GET("api/aliyunsts/token")
//    fun queryAliToken(): Observable<GetAliTokenResult?>?
//
//    @GET("api/tools/getUploadImageToken")
//    fun queryQiniuToken(@Query("fileKey") str: String?): Observable<GetQiniuTokenResult?>?
//}