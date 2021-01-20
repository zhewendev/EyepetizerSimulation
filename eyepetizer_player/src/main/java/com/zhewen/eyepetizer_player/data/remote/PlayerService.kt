package com.zhewen.eyepetizer_player.data.remote

import retrofit2.http.GET

interface PlayerService {

    @GET("api/v4/video/related?id=186856")
    suspend fun fetchVideoDetail()

    @GET("api/v2/replies/video?videoId=186856")
    suspend fun fetchVideoReply()
}