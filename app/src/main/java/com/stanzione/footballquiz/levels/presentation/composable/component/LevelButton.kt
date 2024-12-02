package com.stanzione.footballquiz.levels.presentation.composable.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stanzione.footballquiz.levels.data.model.Level

@Composable
fun LevelButton(
    level: Level,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    if (level.enabled) {
        LevelEnabled(
            level = level,
            modifier = modifier,
            onClick = onClick
        )
    } else {
        LevelDisabled(
            level = level,
            modifier = modifier,
            onClick = onClick
        )
    }
}

@Composable
private fun LevelEnabled(
    level: Level,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        enabled = level.enabled
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(end = 8.dp),
                text = level.label,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${level.score} / ${level.questions}"
            )
        }
    }
}

@Composable
private fun LevelDisabled(
    level: Level,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        enabled = level.enabled
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(end = 8.dp),
                text = level.label,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${level.score} / ${level.minScoreToUnlock} or ${level.coinsToUnlock} coins to unlock"
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
            label = "Level asd asd asdasd asd ad asdsa da dsadasd asd asd asd asd asd ad as",
            questions = 10,
            minScoreToUnlock = 0,
            coinsToUnlock = 0,
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
            minScoreToUnlock = 20,
            coinsToUnlock = 100,
            categoryId = 1,
            enabled = false,
            score = 3,
        ),
        modifier = Modifier,
        onClick = {}
    )
}