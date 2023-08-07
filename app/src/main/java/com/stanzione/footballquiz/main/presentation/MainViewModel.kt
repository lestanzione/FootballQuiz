package com.stanzione.footballquiz.main.presentation

import androidx.lifecycle.ViewModel
import com.stanzione.footballquiz.main.data.model.Category
import com.stanzione.footballquiz.main.domain.usecase.GetCategoriesUseCase
import com.stanzione.footballquiz.main.navigation.MainNavigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val mainNavigation: MainNavigation
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Uninitialized)
    val uiState: StateFlow<UiState> = _uiState

    private fun getCategories() {
        val categories = getCategoriesUseCase.invoke()
        _uiState.update {
            UiState.MainScreen(categories)
        }
    }

    val onUiAction: (UiAction) -> Unit = { uiAction ->

        when (uiAction) {
            is UiAction.Initialize -> getCategories()
            is UiAction.CategorySelected -> {
                mainNavigation.navigationToGame()
            }
        }

    }

    sealed class UiState {
        object Uninitialized : UiState()
        data class MainScreen(
            val categories: List<Category>
        ) : UiState()
    }

    sealed class UiAction {
        object Initialize : UiAction()
        data class CategorySelected(val category: Category) : UiAction()
    }

}