package com.stanzione.footballquiz.main.presentation

import androidx.lifecycle.ViewModel
import com.stanzione.footballquiz.main.domain.usecase.GetCategoriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Uninitialized)
    val uiState: StateFlow<UiState> = _uiState

    sealed class UiState {
        object Uninitialized : UiState()
        object MainScreen : UiState()
    }

}