package com.stanzione.footballquiz.main.presentation

import androidx.lifecycle.ViewModel
import com.stanzione.footballquiz.category.data.model.Category
import com.stanzione.footballquiz.category.domain.usecase.GetCategoriesUseCase
import com.stanzione.footballquiz.main.navigation.MainNavigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainViewModel(
    private val mainNavigation: MainNavigation
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Uninitialized)
    val uiState: StateFlow<UiState> = _uiState

    val onUiAction: (UiAction) -> Unit = { uiAction ->

        when (uiAction) {
            is UiAction.Initialize -> {
                _uiState.update { UiState.MainScreen }
            }

            UiAction.PlayGameSelected -> {
                mainNavigation.navigateToCategoriesScreen()
            }
        }

    }

    sealed class UiState {
        object Uninitialized : UiState()
        object MainScreen : UiState()
    }

    sealed class UiAction {
        object Initialize : UiAction()
        object PlayGameSelected : UiAction()
    }

}