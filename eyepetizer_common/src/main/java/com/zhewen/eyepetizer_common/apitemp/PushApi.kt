package com.zhewen.eyepetizer_common.apitemp

import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


//interface PushApi {
//    @get:GET("v1/content/video/list_issue_tag")
//    val subjectList: Observable<ApiResult<PushSubjectListBean?>?>?
//
//    @FormUrlEncoded
//    @POST("v1/content/issue/create")
//    fun publishWorks(
//        @Field("play_url") str: String?,
//        @Field("image_list") str2: String?,
//        @Field("add_watermark") i: Int,
//        @Field("description") str3: String?,
//        @Field("height") i2: Int,
//        @Field("width") i3: Int,
//        @Field("tag_list") str4: String?,
//        @Field("longitude") d: Double?,
//        @Field("latitude") d2: Double?,
//        @Field("cover_url") str5: String?,
//        @Field("duration") i4: Int,
//        @Field("area") str6: String?,
//        @Field("city") str7: String?
//    ): Observable<PublishResult?>?
//}