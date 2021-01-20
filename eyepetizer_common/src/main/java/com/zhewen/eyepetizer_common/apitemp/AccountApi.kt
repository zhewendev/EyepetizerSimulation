//package com.zhewen.eyepetizer_common.apitemp
//
//import okhttp3.RequestBody
//import retrofit2.http.*
//
//
//interface AccountApi {
//    @GET("/tool/checkDevice")
//    fun checkDevice(): Observable<Any?>?
//
//    @GET
//    fun giveUpBind(@Url str: String?, @Query("status") i: Int): Observable<Any?>?
//
//    @POST("api/tools/image")
//    @Multipart
//    fun updateAvater(@Part("file\"; filename=\"croped_avatar.jpg\"") requestBody: RequestBody?): Observable<UpdateAvaterResult?>?
//
//    @POST("api/tools/image")
//    @Multipart
//    fun updateCover(@Part("file\"; filename=\"croped_cover.jpg\"") requestBody: RequestBody?): Observable<UpdateAvaterResult?>?
//
//    @FormUrlEncoded
//    @POST("api/v5/userInfo/edit")
//    fun updateUserInfo(
//        @Field("nick") str: String?,
//        @Field("gender") str2: String?,
//        @Field("description") str3: String?,
//        @Field("avatar") str4: String?,
//        @Field("cover") str5: String?
//    ): Observable<AccountResponse?>?
//
//    @FormUrlEncoded
//    @POST("api/v5/userInfo/edit")
//    fun updateUserInfo(
//        @Field("nick") str: String?,
//        @Field("gender") str2: String?,
//        @Field("description") str3: String?,
//        @Field("avatar") str4: String?,
//        @Field("cover") str5: String?,
//        @Field("birthday") j: Long,
//        @Field("country") str6: String?,
//        @Field("city") str7: String?,
//        @Field("university") str8: String?,
//        @Field("job") str9: String?
//    ): Observable<AccountResponse?>?
//}