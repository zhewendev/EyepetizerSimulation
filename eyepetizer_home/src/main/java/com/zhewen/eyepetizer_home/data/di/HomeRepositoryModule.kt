package com.zhewen.eyepetizer_home.data.di

import com.zhewen.eyepetizer_home.data.remote.HomeService
import com.zhewen.eyepetizer_home.data.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object HomeRepositoryModule {

    @Provides
    @Singleton
    fun provideDiscoveryRepository(homeService: HomeService): DiscoveryRepositoryImpl {
        return DiscoveryRepositoryImpl(homeService)
    }

    @Provides
    @Singleton
    fun provideDailyRecommendRepository(homeService: HomeService): DailyRecommendRepositoryImpl {
        return DailyRecommendRepositoryImpl(homeService)
    }

    @Provides
    @Singleton
    fun provideDailyFeedRepository(homeService: HomeService): DailyFeedRepositoryImpl {
        return DailyFeedRepositoryImpl(homeService)
    }
}