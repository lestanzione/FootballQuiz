package com.stanzione.footballquiz.optionsgame.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.stanzione.footballquiz.optionsgame.presentation.composable.EndGameScreen
import com.stanzione.footballquiz.optionsgame.presentation.composable.OptionsGameScreen
import com.stanzione.footballquiz.ui.theme.FootballQuizTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class OptionsGameActivity : ComponentActivity() {

    private val optionsGameViewModel: OptionsGameViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val uiState = optionsGameViewModel.uiState.collectAsState()

            FootballQuizTheme {

                when (val currentValue = uiState.value) {
                    OptionsGameViewModel.UiState.Uninitialized -> {
                        optionsGameViewModel.onUiAction(OptionsGameViewModel.UiAction.Initialize)
                    }

                    is OptionsGameViewModel.UiState.GameScreen -> {
                        OptionsGameScreen(
                            optionQuestion = currentValue.optionQuestion,
                            onUiAction = optionsGameViewModel.onUiAction
                        )
                    }

                    OptionsGameViewModel.UiState.EndGame -> {
                        EndGameScreen()
                    }
                }
            }

        }
    }
}