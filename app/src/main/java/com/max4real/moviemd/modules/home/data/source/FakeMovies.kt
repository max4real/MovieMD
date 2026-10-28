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
            Movie(3, "The Dark Knight"),
            Movie(4, "The Matrix"),
            Movie(5, "Pulp Fiction"),
            Movie(6, "Fight Club"),
            Movie(7, "Forrest Gump"),
            Movie(8, "The Lord of the Rings: The Fellowship of the Ring"),
            Movie(9, "Gladiator"),
            Movie(10, "The Godfather"),
            Movie(11, "Schindler's List"),
            Movie(12, "Spider-Man: Into the Spider-Verse"),
            Movie(13, "Parasite"),
            Movie(14, "Whiplash"),
            Movie(15, "The Prestige"),
            Movie(16, "Memento"),
            Movie(17, "Avatar"),
            Movie(18, "Jurassic Park"),
            Movie(19, "Star Wars: Episode V - The Empire Strikes Back"),
            Movie(20, "Blade Runner 2049")
        )
    }
}

class FakeMoviesTest @Inject constructor(
    val fakeMovies: FakeMovies
) {
    suspend fun getTest(): List<String> {
        return fakeMovies.getMovies().map { it.name }
    }
}