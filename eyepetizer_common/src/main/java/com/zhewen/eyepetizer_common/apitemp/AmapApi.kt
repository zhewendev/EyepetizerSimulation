//package com.zhewen.eyepetizer_common.apitemp
//
//import retrofit2.http.GET
//
//
//interface AmapApi {
//    @get:GET("http://restapi.amap.com/v3/ip?key=927dcbc541731b3348417150eed75c0d")
//    val gDIPLocation: Observable<IPBean?>?
//
//    @GET("http://api.map.baidu.com/place/v2/search?radius=3000&output=json&ak=BF5e8c175907e643830184de37ccd748&scope=2&filter=sort_name:distance|sort_rule:1")
//    fun getIPLocationByBaidu(
//        @Query("query") str: String?,
//        @Query("location") str2: String?,
//        @Query("page_size") i: Int,
//        @Query("page_num") i2: Int
//    ): Observable<Any?>?
//
//    @get:GET("http://api.asilu.com/geo/")
//    val iPLocationByOther: Observable<Any?>?
//
//    @GET("http://restapi.amap.com/v3/geocode/regeo?key=927dcbc541731b3348417150eed75c0d&radius=1000&extensions=base&batch=false&roadlevel=0")
//    fun getLocationByGeo(@Query("location") str: String?): Observable<Any?>?
//
//    @GET("http://restapi.amap.com/v3/place/text?key=927dcbc541731b3348417150eed75c0d&offset=20&page=1&extensions=all&output=json")
//    fun inputTips(
//        @Query("keywords") str: String?,
//        @Query("location") str2: String?,
//        @Query("city") str3: String?,
//        @Query("offset") i: Int,
//        @Query("page") i2: Int
//    ): Observable<Any?>?
//}