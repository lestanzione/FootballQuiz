package com.stanzione.footballquiz.scrambledgame

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ScrambledGameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Uninitialized)
    val uiState: StateFlow<UiState> = _uiState

    private var answer = "?????"
    private val letters = listOf("a", "c", "f", "s")

    val onUiAction: (UiAction) -> Unit = { uiAction ->
        when (uiAction) {
            is UiAction.Initialize -> {
                _uiState.value = UiState.GameScreen(
                    answer = answer.toList(),
                    letters = letters
                )
            }

            is UiAction.LetterSelected -> {
                answer = answer.replaceFirst("?", uiAction.letter)
                _uiState.value = UiState.GameScreen(
                    answer = answer.toList(),
                    letters = letters
                )
            }

            is UiAction.LetterRemoved -> {
                val sb = StringBuilder(answer).also {
                    it.setCharAt(uiAction.index, '?')
                }
                answer = sb.toString()
                _uiState.value = UiState.GameScreen(
                    answer = answer.toList(),
                    letters = letters
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
        data class LetterSelected(
            val letter: String
        ) : UiAction()
        data class LetterRemoved(
            val index: Int
        ) : UiAction()
    }

}