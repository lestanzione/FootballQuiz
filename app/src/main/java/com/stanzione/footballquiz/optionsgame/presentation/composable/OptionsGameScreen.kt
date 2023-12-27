package com.stanzione.footballquiz.optionsgame.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.stanzione.footballquiz.optionsgame.presentation.OptionsGameViewModel
import com.stanzione.footballquiz.optionsgame.presentation.composable.component.ImageBox
import com.stanzione.footballquiz.optionsgame.presentation.composable.component.OptionsBox
import com.stanzione.footballquiz.optionsgame.presentation.composable.component.Title

@Composable
fun OptionsGameScreen(
    gameScreen: OptionsGameViewModel.UiState.GameScreen
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(text = "Options Game Activity")
        ImageBox(gameScreen.imageUrl)
        Title(gameScreen.title)
        OptionsBox(gameScreen.options)
    }
}