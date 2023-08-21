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

                            Row {
                                state.answer.forEachIndexed { index, char ->
                                    Text(
                                        text = char.toString(),
                                        fontSize = 24.sp,
                                        modifier = Modifier
                                            .padding(4.dp)
                                            .clickable {
                                                gameViewModel.onUiAction(
                                                    UiAction.LetterRemoved(
                                                        index
                                                    )
                                                )
                                            },
                                        textDecoration = TextDecoration.Underline
                                    )
                                }
                            }

                            Row {
                                state.letters.forEach { letter ->
                                    Button(onClick = {
                                        gameViewModel.onUiAction(
                                            UiAction.LetterSelected(letter)
                                        )
                                    }) {
                                        Text(text = letter)
                                    }
                                }
                            }

                        }
                    }
                }
            }

        }
    }
}