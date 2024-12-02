package com.stanzione.footballquiz.optionsgame.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.stanzione.footballquiz.optionsgame.presentation.OptionsGameViewModel.*
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
                    UiState.Uninitialized -> {
                        optionsGameViewModel.onUiAction(
                            UiAction.Initialize(
                                levelId = intent.getIntExtra(EXTRA_LEVEL_ID, 0)
                            )
                        )
                    }

                    is UiState.GameScreen -> {
                        OptionsGameScreen(
                            currentQuestionNumber = currentValue.currentQuestionNumber,
                            totalQuestionNumber = currentValue.totalQuestionNumber,
                            optionQuestion = currentValue.optionQuestion,
                            onUiAction = optionsGameViewModel.onUiAction
                        )
                    }

                    is UiState.EndGame -> {
                        EndGameScreen(
                            coins = currentValue.coins,
                            score = currentValue.score,
                            totalQuestionNumber = currentValue.totalQuestionNumber,
                            onRestart = {
                                restartGame()
                            }
                        )
                    }
                }
            }

        }
    }

    private fun restartGame() {
        finish()
        startActivity(intent)
    }

    companion object {
        const val EXTRA_LEVEL_ID = "EXTRA_LEVEL_ID"
    }

}