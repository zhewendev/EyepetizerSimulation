package com.zhewen.eyepetizer_home.data.repository

import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun fetchData(): Flow<>
}