package com.max4real.moviemd.modules.home.ui.viewmodel

import androidx.compose.runtime.MutableLongState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.max4real.moviemd.modules.home.domain.model.Movie
import com.max4real.moviemd.modules.home.domain.repo.MovieRepo
import com.max4real.moviemd.modules.home.ui.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    val movieRepo: MovieRepo
) : ViewModel() {
    private val _state = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val state = _state.asStateFlow()

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _state.value = HomeUiState.Loading

            _state.value = try {
                HomeUiState.Success(movieRepo.getMovies())
            } catch (e: Exception) {
                HomeUiState.Error(e.message ?: "sorry")
            }
        }
    }
}