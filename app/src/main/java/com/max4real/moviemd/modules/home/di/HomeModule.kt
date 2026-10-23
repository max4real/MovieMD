package com.max4real.moviemd.modules.home.di

import com.max4real.moviemd.modules.home.data.repo.MovieRepoImpl
import com.max4real.moviemd.modules.home.domain.repo.MovieRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
//object HomeModule {
//    @Provides
//    @Singleton
//    fun Home
//}
abstract class HomeModule {
    @Binds
    @Singleton
    abstract fun provideMovieRepo(impl: MovieRepoImpl): MovieRepo
}