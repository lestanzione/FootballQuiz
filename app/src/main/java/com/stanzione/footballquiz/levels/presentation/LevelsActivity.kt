package com.stanzione.footballquiz.levels.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.stanzione.footballquiz.levels.navigation.LevelsNavigation
import com.stanzione.footballquiz.levels.presentation.LevelsViewModel.*
import com.stanzione.footballquiz.levels.presentation.composable.LevelsScreen
import com.stanzione.footballquiz.optionsgame.presentation.OptionsGameActivity
import com.stanzione.footballquiz.ui.theme.FootballQuizTheme
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class LevelsActivity : ComponentActivity(), LevelsNavigation {

    private val levelsViewModel: LevelsViewModel by viewModel { parametersOf(this) }

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

    override fun navigateToOptionsGame(levelId: Int) {
        val intent = Intent(this, OptionsGameActivity::class.java).apply {
            putExtra(OptionsGameActivity.EXTRA_LEVEL_ID, levelId)
        }
        startActivity(intent)
    }

    companion object {
        const val EXTRA_CATEGORY_ID = "EXTRA_CATEGORY_ID"
    }
}
