package com.zhewen.eyepetizer_home.data.di

import com.zhewen.eyepetizer_home.data.remote.HomeService
import com.zhewen.eyepetizer_home.data.repository.HomeRepository
import com.zhewen.eyepetizer_home.data.repository.HomeRepositoryImpl
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
    fun provideHomeRepository(homeService: HomeService): HomeRepository {
        return HomeRepositoryImpl(homeService)
    }
}