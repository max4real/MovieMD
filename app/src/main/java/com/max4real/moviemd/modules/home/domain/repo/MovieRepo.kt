package com.max4real.moviemd.modules.home.domain.repo

import com.max4real.moviemd.modules.home.domain.model.Movie

interface MovieRepo {
    suspend fun getMovies(): List<Movie>
}