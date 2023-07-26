package com.stanzione.footballquiz.main.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Uninitialized)

    sealed class UiState {
        object Uninitialized : UiState()
        object MainScreen : UiState()
    }

}