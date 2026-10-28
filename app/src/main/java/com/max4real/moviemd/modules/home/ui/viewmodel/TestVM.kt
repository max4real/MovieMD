package com.max4real.moviemd.modules.home.ui.viewmodel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.max4real.moviemd.modules.home.data.repo.TestRepoImpl
import com.max4real.moviemd.modules.home.domain.repo.TestRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TestVM @Inject constructor(
    testRepo: TestRepo
) : ViewModel() {

    private val _list = MutableStateFlow<List<String>>(emptyList())
    val list = _list.asStateFlow()

    init {
        viewModelScope.launch {
            _list.value = testRepo.getTestData()
        }
    }
}