package com.max4real.moviemd.modules.home.ui.screen

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.max4real.moviemd.modules.home.ui.viewmodel.TestVM

@Composable
fun TestPage(
    vm: TestVM = hiltViewModel()
) {
    vm.list
}