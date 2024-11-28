package com.stanzione.footballquiz.levels.presentation.composable.component

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        onClick = onClick
    ) {
        Text(
            text = level.label,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
private fun LevelButtonPreview() {
    LevelButton(
        level = Level(
            id = 1,
            label = "Level",
            enabled = true,
            questions = 10,
            score = 10,
            categoryId = 1,
        ),
        modifier = Modifier,
        onClick = {}
    )
}