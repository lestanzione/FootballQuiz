package com.stanzione.footballquiz.levels.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.stanzione.footballquiz.levels.presentation.LevelsViewModel.*
import com.stanzione.footballquiz.levels.presentation.composable.LevelsScreen
import com.stanzione.footballquiz.ui.theme.FootballQuizTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class LevelsActivity : ComponentActivity() {

    private val levelsViewModel: LevelsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val uiState = levelsViewModel.uiState.collectAsState()

            FootballQuizTheme {
                when (val currentValue = uiState.value) {
                    UiState.Uninitialized -> {
                        levelsViewModel.onUiAction(
                            UiAction.Initialize(
                                categoryId = intent.getIntExtra(EXTRA_CATEGORY_ID, 0)
                            )
                        )
                    }

                    is UiState.LevelsScreen -> {
                        LevelsScreen(
                            levels = currentValue.levels,
                            onUiAction = levelsViewModel.onUiAction
                        )
                    }
                }
            }
        }
    }

    companion object {
        const val EXTRA_CATEGORY_ID = "EXTRA_CATEGORY_ID"
    }

}
