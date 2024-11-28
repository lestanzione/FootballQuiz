package com.stanzione.footballquiz.levels.presentation

import androidx.lifecycle.ViewModel
import com.stanzione.footballquiz.levels.data.model.Level
import com.stanzione.footballquiz.levels.domain.usecase.GetLevelsUseCase
import com.stanzione.footballquiz.levels.navigation.LevelsNavigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LevelsViewModel(
    private val getLevelsUseCase: GetLevelsUseCase,
    private val levelsNavigation: LevelsNavigation
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Uninitialized)
    val uiState: StateFlow<UiState> = _uiState

    val onUiAction: (UiAction) -> Unit = { uiAction ->
        when (uiAction) {
            is UiAction.Initialize -> getLevels(uiAction.categoryId)
            is UiAction.LevelSelected -> levelsNavigation.navigateToOptionsGame()
        }
    }

    private fun getLevels(categoryId: Int) {
        val levels = getLevelsUseCase.invoke(categoryId)
        _uiState.update {
            UiState.LevelsScreen(
                levels = levels
            )
        }
    }

    sealed class UiState {
        object Uninitialized : UiState()
        data class LevelsScreen(
            val levels: List<Level>
        ) : UiState()
    }

    sealed class UiAction {
        data class Initialize(val categoryId: Int) : UiAction()
        data class LevelSelected(val level: Level) : UiAction()
    }
}