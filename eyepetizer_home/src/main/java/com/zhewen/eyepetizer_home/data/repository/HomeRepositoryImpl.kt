package com.zhewen.eyepetizer_home.data.repository

import com.zhewen.eyepetizer_home.data.remote.HomeService
import kotlinx.coroutines.flow.Flow

class HomeRepositoryImpl(val api:HomeService):HomeRepository {
    override fun fetchData(): Flow<???> {
        TODO("Not yet implemented")
    }

}