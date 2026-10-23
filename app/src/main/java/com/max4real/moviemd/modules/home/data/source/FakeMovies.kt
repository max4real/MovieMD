package com.max4real.moviemd.modules.home.data.source

import com.max4real.moviemd.modules.home.domain.model.Movie
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

class FakeMovies @Inject constructor() {
    suspend fun getMovies(): List<Movie> {
        delay(500.milliseconds)
        return listOf(
            Movie(1, "Inception"),
            Movie(2, "Interstellar"),
            Movie(3, "The Dark Knight")
        )
    }
}