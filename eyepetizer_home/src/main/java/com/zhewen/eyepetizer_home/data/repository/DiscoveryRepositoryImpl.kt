package com.zhewen.eyepetizer_home.data.repository

import com.orhanobut.logger.Logger
import com.zhewen.eyepetizer_common.network.ResponseResult
import com.zhewen.eyepetizer_home.data.model.DiscoveryModel
import com.zhewen.eyepetizer_home.data.remote.HomeService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * discovery Fragment页面数据仓库实现
 */
class DiscoveryRepositoryImpl @Inject constructor(private val api: HomeService) {
    suspend fun fetchDiscoveryPage(): Flow<ResponseResult<DiscoveryModel>> {
        return flow {
            //如果有数据库，增加从数据库获取数据的相关逻辑
            try {
                val discoveryModel = api.fetchDiscoveryPage()
                emit(ResponseResult.Success(discoveryModel))
            } catch (e: Exception) {
                emit(ResponseResult.Failure(e.cause))
            }
        }.flowOn(Dispatchers.IO)
    }
}