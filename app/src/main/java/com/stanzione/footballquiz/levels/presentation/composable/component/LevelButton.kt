package com.stanzione.footballquiz.levels.presentation.composable.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.stanzione.footballquiz.levels.data.model.Level

@Composable
fun LevelButton(
    level: Level,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = level.enabled
    ) {
        Column {
            Text(
                text = level.label,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${level.score} / ${level.questions}"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LevelButtonEnabledPreview() {
    LevelButton(
        level = Level(
            id = 1,
            label = "Level",
            questions = 10,
            minScoreToUnlock = 0,
            categoryId = 1,
            enabled = true,
            score = 3,
        ),
        modifier = Modifier,
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun LevelButtonDisabledPreview() {
    LevelButton(
        level = Level(
            id = 1,
            label = "Level",
            questions = 10,
            minScoreToUnlock = 0,
            categoryId = 1,
            enabled = false,
            score = 3,
        ),
        modifier = Modifier,
        onClick = {}
    )
}