package com.stanzione.footballquiz.main.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.stanzione.footballquiz.category.presentation.CategoriesActivity
import com.stanzione.footballquiz.main.navigation.MainNavigation
import com.stanzione.footballquiz.main.presentation.MainViewModel.UiAction
import com.stanzione.footballquiz.main.presentation.MainViewModel.UiState
import com.stanzione.footballquiz.main.presentation.composable.MainScreen
import com.stanzione.footballquiz.ui.theme.FootballQuizTheme
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity(), MainNavigation {

    private val mainViewModel: MainViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val uiState = mainViewModel.uiState.collectAsState()

            FootballQuizTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    when (uiState.value) {
                        is UiState.Uninitialized -> {
                            mainViewModel.onUiAction(UiAction.Initialize)
                        }

                        is UiState.MainScreen -> MainScreen(
                            onUiAction = mainViewModel.onUiAction
                        )
                    }
                }
            }
        }
    }

    override fun navigateToCategoriesScreen() {
        val intent = Intent(this, CategoriesActivity::class.java)
        startActivity(intent)
    }
}