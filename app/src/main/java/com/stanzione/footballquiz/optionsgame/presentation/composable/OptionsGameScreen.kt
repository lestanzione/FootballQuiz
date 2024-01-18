package com.stanzione.footballquiz.optionsgame.presentation.composable

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.stanzione.footballquiz.optionsgame.data.model.OptionQuestion
import com.stanzione.footballquiz.optionsgame.presentation.OptionsGameViewModel.*
import com.stanzione.footballquiz.optionsgame.presentation.composable.component.ImageBox
import com.stanzione.footballquiz.optionsgame.presentation.composable.component.OptionsBox
import com.stanzione.footballquiz.optionsgame.presentation.composable.component.Title

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun OptionsGameScreen(
    optionQuestion: OptionQuestion,
    onUiAction: (UiAction) -> Unit
) {
    val CONTENT_ANIMATION_DURATION = 200

    AnimatedContent(
        targetState = optionQuestion,
        transitionSpec = {
            // Going forwards in the survey: Set the initial offset to start
            // at the size of the content so it slides in from right to left, and
            // slides out from the left of the screen to -fullWidth
            slideInHorizontally(
                animationSpec = tween(CONTENT_ANIMATION_DURATION),
                initialOffsetX = { fullWidth -> fullWidth }
            ) with
                slideOutHorizontally(
                    animationSpec = tween(CONTENT_ANIMATION_DURATION),
                    targetOffsetX = { fullWidth -> -fullWidth }
                )
        }, label = "QuestionTransition"
    ) { targetState ->
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            ImageBox(targetState.imageUrl)
            Title(targetState.title)
            OptionsBox(
                optionList = targetState.optionList,
                onUiAction = onUiAction
            )
        }
    }
}