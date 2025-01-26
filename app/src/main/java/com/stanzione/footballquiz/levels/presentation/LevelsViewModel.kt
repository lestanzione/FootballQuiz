package com.stanzione.footballquiz.levels.presentation

import androidx.lifecycle.ViewModel
import com.stanzione.footballquiz.coins.domain.usecase.GetCoinsUseCase
import com.stanzione.footballquiz.coins.domain.usecase.RemoveCoinsUseCase
import com.stanzione.footballquiz.levels.data.model.Level
import com.stanzione.footballquiz.levels.domain.usecase.GetLevelsUseCase
import com.stanzione.footballquiz.levels.domain.usecase.UnlockLevelUseCase
import com.stanzione.footballquiz.levels.navigation.LevelsNavigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LevelsViewModel(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val getLevelsUseCase: GetLevelsUseCase,
    private val removeCoinsUseCase: RemoveCoinsUseCase,
    private val unlockLevelUseCase: UnlockLevelUseCase,
    private val levelsNavigation: LevelsNavigation
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Uninitialized)
    val uiState: StateFlow<UiState> = _uiState

    val onUiAction: (UiAction) -> Unit = { uiAction ->
        when (uiAction) {
            is UiAction.Initialize -> getLevels(uiAction.categoryId)
            is UiAction.LevelSelected -> levelsNavigation.navigateToOptionsGame(levelId = uiAction.level.id)
            is UiAction.UnlockLevel -> {
                unlockLevelUseCase.execute(uiAction.level.id)
                removeCoinsUseCase.execute(uiAction.level.coinsToUnlock)
            }
        }
    }

    private fun getLevels(categoryId: Int) {
        val coins = getCoinsUseCase.execute()
        val levels = getLevelsUseCase.execute(categoryId)
        _uiState.update {
            UiState.LevelsScreen(
                coins = coins,
                levels = levels
            )
        }
    }

    sealed class UiState {
        object Uninitialized : UiState()
        data class LevelsScreen(
            val coins: Int,
            val levels: List<Level>
        ) : UiState()
    }

    sealed class UiAction {
        data class Initialize(val categoryId: Int) : UiAction()
        data class LevelSelected(val level: Level) : UiAction()
        data class UnlockLevel(val level: Level) : UiAction()
    }
}