package com.stanzione.footballquiz.category.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.stanzione.footballquiz.category.navigation.CategoriesNavigation
import com.stanzione.footballquiz.category.presentation.CategoriesViewModel.UiAction
import com.stanzione.footballquiz.category.presentation.CategoriesViewModel.UiState
import com.stanzione.footballquiz.category.presentation.composable.CategoriesScreen
import com.stanzione.footballquiz.levels.presentation.LevelsActivity
import com.stanzione.footballquiz.main.presentation.composable.MainScreen
import com.stanzione.footballquiz.optionsgame.presentation.OptionsGameActivity
import com.stanzione.footballquiz.ui.theme.FootballQuizTheme
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CategoriesActivity : ComponentActivity(), CategoriesNavigation {

    private val categoriesViewModel: CategoriesViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val uiState = categoriesViewModel.uiState.collectAsState()

            FootballQuizTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    when (val state = uiState.value) {
                        is UiState.Uninitialized -> {
                            categoriesViewModel.onUiAction(UiAction.Initialize)
                        }

                        is UiState.CategoriesScreen -> CategoriesScreen(
                            state.categories,
                            categoriesViewModel.onUiAction
                        )
                    }
                }
            }
        }
    }

    override fun navigateToOptionsGame() {
        val intent = Intent(this, OptionsGameActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToLevelsScreen(categoryId: Int) {
        val intent = Intent(this, LevelsActivity::class.java).apply {
            putExtra(LevelsActivity.EXTRA_CATEGORY_ID, categoryId)
        }
        startActivity(intent)
    }
}
