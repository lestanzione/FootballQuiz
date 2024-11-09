package com.stanzione.footballquiz.main.presentation

import androidx.lifecycle.ViewModel
import com.stanzione.footballquiz.category.data.model.Category
import com.stanzione.footballquiz.category.domain.usecase.GetCategoriesUseCase
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

            UiAction.PlayGameSelected -> {
                mainNavigation.navigateToCategoriesScreen()
            }

            is UiAction.CategorySelected -> {
                if (uiAction.category.id == 1) {
                    mainNavigation.navigateToOptionsGame()
                } else {
                    mainNavigation.navigateToScrambledGame()
                }
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
        object PlayGameSelected : UiAction()
        data class CategorySelected(val category: Category) : UiAction()
    }

}