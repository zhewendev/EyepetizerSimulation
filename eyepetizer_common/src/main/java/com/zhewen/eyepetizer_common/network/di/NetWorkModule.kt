package com.zhewen.eyepetizer_common.network.di

import com.zhewen.eyepetizer_common.constant.CommonConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * 网络请求实例依赖注入
 */
@Module
@InstallIn(ApplicationComponent::class)
object NetWorkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClientManager.sOkHttpClientManager.getOkHttpClient()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return RetrofitManager.sRetrofitManager.setClient(okHttpClient).getRetrofit()
    }
}