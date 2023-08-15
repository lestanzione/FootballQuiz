package com.stanzione.footballquiz.game

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Uninitialized)
    val uiState: StateFlow<UiState> = _uiState

    private var answer = "?????"

    val onUiAction: (UiAction) -> Unit = { uiAction ->
        when (uiAction) {
            is UiAction.Initialize -> {
                _uiState.value = UiState.GameScreen(
                    answer = answer.toList(),
                    letters = listOf("a", "c", "f", "s")
                )
            }
        }
    }

    sealed class UiState {
        object Uninitialized : UiState()
        data class GameScreen(
            val answer: List<Char>,
            val letters: List<String>
        ) : UiState()
    }

    sealed class UiAction {
        object Initialize : UiAction()
    }

}