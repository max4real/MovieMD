package com.max4real.moviemd.modules.home.di

import com.max4real.moviemd.modules.home.data.repo.MovieRepoImpl
import com.max4real.moviemd.modules.home.data.repo.TestRepoImpl
import com.max4real.moviemd.modules.home.domain.repo.MovieRepo
import com.max4real.moviemd.modules.home.domain.repo.TestRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeModule {
    @Binds
    @Singleton
    abstract fun bindMovieRepo(impl: MovieRepoImpl): MovieRepo

    @Binds
    @Singleton
    abstract fun bindTestRepo(impl: TestRepoImpl): TestRepo
}
