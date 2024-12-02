package com.stanzione.footballquiz.levels.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
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

            val lifecycleOwner = LocalLifecycleOwner.current
            DisposableEffect(lifecycleOwner) {
                val observer = LifecycleEventObserver { _, event ->
                    if (event == Lifecycle.Event.ON_RESUME) {
                        levelsViewModel.onUiAction(
                            UiAction.Initialize(
                                categoryId = intent.getIntExtra(EXTRA_CATEGORY_ID, 0)
                            )
                        )
                    }
                }

                lifecycleOwner.lifecycle.addObserver(observer)
                onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
            }

            FootballQuizTheme {
                when (val currentValue = uiState.value) {
                    UiState.Uninitialized -> {
//                        levelsViewModel.onUiAction(
//                            UiAction.Initialize(
//                                categoryId = intent.getIntExtra(EXTRA_CATEGORY_ID, 0)
//                            )
//                        )
                    }

                    is UiState.LevelsScreen -> {
                        LevelsScreen(
                            coins = currentValue.coins,
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
