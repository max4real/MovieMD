package com.max4real.moviemd.modules.home.data.repo

import com.max4real.moviemd.modules.home.data.source.FakeMovies
import com.max4real.moviemd.modules.home.domain.model.Movie
import com.max4real.moviemd.modules.home.domain.repo.MovieRepo
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(
    val fakeMovies: FakeMovies
) : MovieRepo {
    override suspend fun getMovies(): List<Movie> {
        return fakeMovies.getMovies()
    }
}