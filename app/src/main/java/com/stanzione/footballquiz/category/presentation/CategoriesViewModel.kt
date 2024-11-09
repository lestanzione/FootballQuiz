package com.stanzione.footballquiz.category.presentation

import androidx.lifecycle.ViewModel
import com.stanzione.footballquiz.category.data.model.Category
import com.stanzione.footballquiz.category.domain.usecase.GetCategoriesUseCase
import com.stanzione.footballquiz.category.navigation.CategoriesNavigation
import com.stanzione.footballquiz.main.navigation.MainNavigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CategoriesViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val categoriesNavigation: CategoriesNavigation
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Uninitialized)
    val uiState: StateFlow<UiState> = _uiState

    private fun getCategories() {
        val categories = getCategoriesUseCase.invoke()
        _uiState.update {
            UiState.CategoriesScreen(categories)
        }
    }

    val onUiAction: (UiAction) -> Unit = { uiAction ->

        when (uiAction) {
            is UiAction.Initialize -> getCategories()

            is UiAction.CategorySelected -> {
                categoriesNavigation.navigateToOptionsGame()
//                if (uiAction.category.id == 1) {
//                    categoriesNavigation.navigateToOptionsGame()
//                } else {
//                    categoriesNavigation.navigateToScrambledGame()
//                }
            }
        }

    }

    sealed class UiState {
        object Uninitialized : UiState()
        data class CategoriesScreen(
            val categories: List<Category>
        ) : UiState()
    }

    sealed class UiAction {
        object Initialize : UiAction()
        data class CategorySelected(val category: Category) : UiAction()
    }

}