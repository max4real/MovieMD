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
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

@HiltViewModel
class HomeVM @Inject constructor(
    val movieRepo: MovieRepo
) : ViewModel() {
    private val _state = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val state = _state.asStateFlow()

    private val _favIds = MutableStateFlow<Set<String>>(emptySet())
    val favIds = _favIds.asStateFlow()

    fun toggleFav(id: String) {
        _favIds.update { ids ->
            if (id in ids) ids - id else ids + id
        }
    }

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _state.value = HomeUiState.Loading
            _state.value = try {
                HomeUiState.Success(movieRepo.getMovies())
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                HomeUiState.Error(e.message ?: "Something went wrong")
            }
        }
    }
}