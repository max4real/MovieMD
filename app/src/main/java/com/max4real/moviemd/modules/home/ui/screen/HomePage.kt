package com.max4real.moviemd.modules.home.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.max4real.moviemd.modules.home.domain.model.Movie
import com.max4real.moviemd.modules.home.ui.state.HomeUiState
import com.max4real.moviemd.modules.home.ui.viewmodel.HomeVM
import com.max4real.moviemd.modules.home.ui.widget.MovieCard

@Composable
fun HomePage(
    vm: HomeVM = hiltViewModel()
) {
    val state by vm.state.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        when (val s = state) {
            HomeUiState.Loading -> CircularProgressIndicator()
            is HomeUiState.Error -> Column {
                Text(s.message)
                Button(onClick = vm::load) { Text("Retry") }
            }

            is HomeUiState.Success -> LazyColumn { items(s.movies) { MovieCard(title = it.name) } }
        }
    }
}