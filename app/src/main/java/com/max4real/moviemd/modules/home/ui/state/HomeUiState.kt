package com.max4real.moviemd.modules.home.ui.state

import com.max4real.moviemd.modules.home.domain.model.Movie

 interface HomeUiState {
    data object Loading : HomeUiState
    data class Success(val movies: List<Movie>) : HomeUiState
    data class Error(val message: String) : HomeUiState
}