package com.max4real.moviemd.modules.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeVM @Inject constructor(

) : ViewModel() {
    val name = "Hello World"
}