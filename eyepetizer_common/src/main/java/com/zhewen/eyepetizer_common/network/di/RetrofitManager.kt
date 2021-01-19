package com.zhewen.eyepetizer_common.network.di

import com.zhewen.eyepetizer_common.constant.CommonConstant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit管理器
 */

class RetrofitManager private constructor() {

    private val mRetrofitBuilder = Retrofit.Builder()

    companion object {
        val sRetrofitManager = SingletonHolder.holder
    }

    private object SingletonHolder {
        val holder = RetrofitManager()
    }

    fun setClient(okHttpClient: OkHttpClient): RetrofitManager {
        mRetrofitBuilder.client(okHttpClient)
        return this
    }

    init {
        mRetrofitBuilder.baseUrl(CommonConstant.REQUEST_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    /**
     * 返回Retrofit实例
     */
    fun getRetrofit(): Retrofit {
        return mRetrofitBuilder.build()
    }
}