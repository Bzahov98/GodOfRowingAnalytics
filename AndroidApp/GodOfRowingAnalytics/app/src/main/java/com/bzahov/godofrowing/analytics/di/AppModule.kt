package com.bzahov.godofrowing.analytics.di

import android.content.Context
import com.bzahov.godofrowing.analytics.data.local.PreferencesDataSource
import com.bzahov.godofrowing.analytics.data.network.dataStore.AuthDataSource
import com.bzahov.godofrowing.analytics.data.network.dataStore.ImagesDataSource
import com.bzahov.godofrowing.analytics.data.repositories.AuthRepoImpl
import com.bzahov.godofrowing.analytics.data.repositories.PreferencesRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAuthDataSource(): AuthDataSource =
        AuthDataSource()

    @Provides
    @Singleton
    fun provideAuthRepository(
        authDataSource: AuthDataSource,
        preferencesDataSource: PreferencesDataSource,
        imagesDataSource: ImagesDataSource
    ): AuthRepoImpl = AuthRepoImpl(authDataSource, preferencesDataSource, imagesDataSource)



    @Provides
    @Singleton
    fun providePreferencesDataSource(
        @ApplicationContext context: Context,
    ): PreferencesDataSource =
        PreferencesDataSource(context)

    @Provides
    @Singleton
    fun providePreferencesRepo(
        preferencesDataSource: PreferencesDataSource,
    ): PreferencesRepoImpl = PreferencesRepoImpl(preferencesDataSource)

}