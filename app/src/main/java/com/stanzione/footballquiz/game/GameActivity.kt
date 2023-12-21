package com.stanzione.footballquiz.game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stanzione.footballquiz.game.GameViewModel.UiAction
import com.stanzione.footballquiz.game.GameViewModel.UiState
import com.stanzione.footballquiz.ui.theme.FootballQuizTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameActivity : ComponentActivity() {

    private val gameViewModel: GameViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val uiState = gameViewModel.uiState.collectAsState()

            FootballQuizTheme {
                when (val state = uiState.value) {
                    is UiState.Uninitialized -> {
                        gameViewModel.onUiAction(UiAction.Initialize)
                    }

                    is UiState.GameScreen -> {

                        Column {
                            AnswerRow(
                                answer = state.answer,
                                onClick = gameViewModel.onUiAction
                            )
                            LettersRow(
                                letters = state.letters,
                                onClick = gameViewModel.onUiAction
                            )
                        }
                    }
                }
            }

        }
    }
}

@Composable
private fun AnswerRow(
    answer: List<Char>,
    onClick: (UiAction) -> Unit
) {
    Row {
        answer.forEachIndexed { index, char ->
            Text(
                text = char.toString(),
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(4.dp)
                    .clickable {
                        onClick(
                            UiAction.LetterRemoved(index)
                        )
                    },
                textDecoration = TextDecoration.Underline
            )
        }
    }
}

@Composable
private fun LettersRow(
    letters: List<String>,
    onClick: (UiAction) -> Unit
) {
    Row {
        letters.forEach { letter ->
            Button(onClick = {
                onClick(UiAction.LetterSelected(letter))
            }) {
                Text(text = letter)
            }
        }
    }
}