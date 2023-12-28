package com.stanzione.footballquiz.optionsgame.presentation

import androidx.lifecycle.ViewModel
import com.stanzione.footballquiz.optionsgame.data.model.OptionQuestion
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OptionsGameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Uninitialized)
    val uiState: StateFlow<UiState> = _uiState

    val onUiAction: (UiAction) -> Unit = { uiAction ->
        when (uiAction) {
            UiAction.Initialize -> {
                _uiState.value = UiState.GameScreen(
                    OptionQuestion(
                        title = "Quem é esse jogador?",
                        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjCjgVv-4Cl9Z-XQT3uCV_KKtjPzSNG-q2XA&usqp=CAU",
                        optionList = listOf(
                            "Cristiano Ronaldo",
                            "Messi",
                            "Mbappé",
                            "Rony"
                        )
                    )
                )
            }

            UiAction.SelectOption -> {
                _uiState.value = UiState.GameScreen(
                    OptionQuestion(
                        title = "Quem é esse jogador?",
                        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjCjgVv-4Cl9Z-XQT3uCV_KKtjPzSNG-q2XA&usqp=CAU",
                        optionList = listOf(
                            "Pelé",
                            "Messi",
                            "Benjamin",
                            "Cristiano Ronaldo"
                        )
                    )
                )
            }
        }
    }

    sealed class UiState {
        object Uninitialized : UiState()
        data class GameScreen(
            val optionQuestion: OptionQuestion
        ) : UiState()
    }

    sealed class UiAction {
        object Initialize : UiAction()
        object SelectOption : UiAction()
    }

}