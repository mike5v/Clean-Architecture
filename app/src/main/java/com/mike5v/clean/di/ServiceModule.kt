package com.mike5v.clean.di

import com.mike5v.api.RetrofitCatsApi
import com.mike5v.data.CatsServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    fun provideService(): CatsServices = RetrofitCatsApi()
}