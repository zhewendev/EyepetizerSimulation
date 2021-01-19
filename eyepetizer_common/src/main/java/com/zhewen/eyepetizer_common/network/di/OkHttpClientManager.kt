package com.zhewen.eyepetizer_common.network.di

import com.zhewen.eyepetizer_common.network.cache.CacheMode
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * OKHttpClient管理器
 */
// TODO: 2021/1/19
class OkHttpClientManager private constructor() {

    private val mOkHttpClientBuilder = OkHttpClient.Builder()
    private val mCacheMode: CacheMode = CacheMode.NO_CACHE //缓存类型
    private val mCacheTime: Long = -1 //缓存时间


    companion object {
        val sOkHttpClientManager = SingletonHolder.holder
        const val DEFAULT_MILLISECONDS = 15000L  //默认的网络连接时间
        const val DEFAULT_RETRY_COUNT = 3   //默认重试次数
        const val DEFAULT_RETRY_INCREASE_DELAY = 0   //默认重试叠加时间
        const val DEFAULT_RETRY_DELAY = 500     //默认重试延时
        const val DEFAULT_CACHE_NEVER_EXPIRE = -1 //缓存过期时间，默认永久缓存
    }

    private object SingletonHolder {
        val holder = OkHttpClientManager()
    }

    init {
        mOkHttpClientBuilder.connectTimeout(
            DEFAULT_MILLISECONDS,
            TimeUnit.MILLISECONDS
        )
            .readTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)
            .writeTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)
    }

    fun getOkHttpClient():OkHttpClient{
        return mOkHttpClientBuilder.build()
    }


}