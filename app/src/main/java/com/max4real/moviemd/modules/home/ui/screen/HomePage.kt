package com.max4real.moviemd.modules.home.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.max4real.moviemd.modules.home.ui.state.HomeUiState
import com.max4real.moviemd.modules.home.ui.viewmodel.HomeVM

@Composable
fun HomePage(
    vm: HomeVM = hiltViewModel()
) {
    val state by vm.state.collectAsState()

    when (val s = state) {
        HomeUiState.Loading -> CircularProgressIndicator()
        is HomeUiState.Error -> Column {
            Text(s.message)
            Button(onClick = vm::load) { Text("Retry") }
        }

        is HomeUiState.Success -> LazyColumn { items(s.movies) { Text(it.name) } }
    }
}