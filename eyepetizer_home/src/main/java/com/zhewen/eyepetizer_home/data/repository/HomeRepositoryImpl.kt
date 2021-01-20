package com.zhewen.eyepetizer_home.data.repository

import com.zhewen.eyepetizer_home.data.remote.HomeService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor (val api:HomeService):HomeRepository {
    override suspend fun fetchDiscoveryPage(): Flow<???> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchDailyRecommendPage(): Flow<???> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchDailyFeedPage(): Flow<???> {
        TODO("Not yet implemented")
    }


}