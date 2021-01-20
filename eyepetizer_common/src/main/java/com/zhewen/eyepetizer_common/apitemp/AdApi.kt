//package com.zhewen.eyepetizer_common.apitemp
//
//import okhttp3.ResponseBody
//import retrofit2.http.GET
//import retrofit2.http.Streaming
//import retrofit2.http.Url
//
//
//interface AdApi {
//    @GET
//    fun call(@Header("User-Agent") str: String?, @Url str2: String?): Observable<ResponseBody?>?
//
//    @Streaming
//    @GET
//    fun download(@Header("User-Agent") str: String?, @Url str2: String?): Observable<ResponseBody?>?
//
//    @GET
//    fun getDownloadInfo(
//        @Header("User-Agent") str: String?,
//        @Url str2: String?
//    ): Observable<MoleiDownInfoModel?>?
//}