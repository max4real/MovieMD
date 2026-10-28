package com.max4real.moviemd.modules.home.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.max4real.moviemd.modules.home.domain.model.Movie
import com.max4real.moviemd.modules.home.ui.state.HomeUiState
import com.max4real.moviemd.modules.home.ui.viewmodel.HomeVM
import com.max4real.moviemd.modules.home.ui.widget.MovieCard

// Stateful: the only composable that knows the ViewModel exists.
@Composable
fun HomePage(
    vm: HomeVM = hiltViewModel()
) {
    val state by vm.state.collectAsState()
    val favIds by vm.favIds.collectAsState()

    HomeContent(
        state = state,
        favIds = favIds,
        onRetry = vm::load,
        onTapFav = vm::toggleFav
    )
}

// Stateless: draws whatever it is given, so every state can be previewed.
@Composable
private fun HomeContent(
    state: HomeUiState,
    favIds: Set<String>,
    onRetry: () -> Unit,
    onTapFav: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(top = 50.dp)
            .fillMaxSize()
    ) {
        Text(
            text = favIds.size.toString(),
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            when (state) {
                HomeUiState.Loading -> CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )

                is HomeUiState.Error -> Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = state.message, color = Color.White)
                    Button(onClick = onRetry) { Text("Retry") }
                }

                is HomeUiState.Success -> LazyColumn {
                    items(state.movies, key = { it.id }) { movie ->
                        val id = movie.id.toString()
                        MovieCard(
                            title = movie.name,
                            isFav = id in favIds,
                            onTapFav = { onTapFav(id) }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeLoadingPreview() {
    HomeContent(HomeUiState.Loading, emptySet(), {}, {})
}

@Preview(showBackground = true)
@Composable
private fun HomeErrorPreview() {
    HomeContent(HomeUiState.Error("No internet"), emptySet(), {}, {})
}

@Preview(showBackground = true)
@Composable
private fun HomeSuccessPreview() {
    HomeContent(
        state = HomeUiState.Success(
            listOf(Movie(1, "Inception"), Movie(2, "Interstellar"))
        ),
        favIds = setOf("1"),
        onRetry = {},
        onTapFav = {}
    )
}
