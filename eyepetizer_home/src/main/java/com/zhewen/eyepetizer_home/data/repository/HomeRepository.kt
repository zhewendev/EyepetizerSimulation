package com.zhewen.eyepetizer_home.data.repository

import com.zhewen.eyepetizer_common.network.ResponseResult
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun fetchDiscoveryPage(): Flow<ResponseResult<>>

    suspend fun fetchDailyRecommendPage(): Flow<ResponseResult<>>

    suspend fun fetchDailyFeedPage(): Flow<ResponseResult<>>
}