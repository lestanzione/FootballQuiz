package com.stanzione.footballquiz.levels.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stanzione.footballquiz.levels.data.model.Level
import com.stanzione.footballquiz.levels.presentation.LevelsViewModel
import com.stanzione.footballquiz.levels.presentation.composable.component.LevelButton

private var levelToUnlock: Level? = null

@Composable
fun LevelsScreen(
    coins: Int,
    levels: List<Level>,
    onUiAction: (LevelsViewModel.UiAction) -> Unit
) {
    var showUnlockLevelDialog by remember {
        mutableStateOf(0)
    }

    Column {
        Row {
            Text(
                text = "$coins coins"
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(levels) { level ->
                LevelButton(
                    level = level,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    if (level.enabled) {
                        onUiAction(LevelsViewModel.UiAction.LevelSelected(level))
                    } else {
                        levelToUnlock = level
                        showUnlockLevelDialog = level.coinsToUnlock
                    }
                }
            }
        }
    }

    if (showUnlockLevelDialog != 0) {
        UnlockLevelDialog(
            coinsToUnlock = showUnlockLevelDialog,
            onDismiss = {
                showUnlockLevelDialog = 0
            },
            onUnlock = {
                onUiAction(LevelsViewModel.UiAction.UnlockLevel(levelToUnlock!!))
                showUnlockLevelDialog = 0
                onUiAction(LevelsViewModel.UiAction.LevelSelected(levelToUnlock!!))
            }
        )
    }
}
