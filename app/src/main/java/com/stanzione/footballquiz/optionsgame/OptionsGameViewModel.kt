package com.stanzione.footballquiz.optionsgame

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OptionsGameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Uninitialized)
    val uiState: StateFlow<UiState> = _uiState

    val onUiAction: (UiAction) -> Unit = { uiAction ->
        when (uiAction) {
            UiAction.Initialize -> {
                _uiState.value = UiState.GameScreen(
                    title = "Quem é esse jogador?",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjCjgVv-4Cl9Z-XQT3uCV_KKtjPzSNG-q2XA&usqp=CAU",
                    options = listOf(
                        "Cristiano Ronaldo",
                        "Messi",
                        "Mbappé",
                        "Rony"
                    )
                )
            }
        }
    }

    sealed class UiState {
        object Uninitialized : UiState()
        data class GameScreen(
            val title: String,
            val imageUrl: String,
            val options: List<String>
        ) : UiState()
    }

    sealed class UiAction {
        object Initialize : UiAction()
    }

}