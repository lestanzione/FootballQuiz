package com.stanzione.footballquiz.levels.presentation.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stanzione.footballquiz.levels.data.model.Level
import com.stanzione.footballquiz.levels.presentation.LevelsViewModel
import com.stanzione.footballquiz.levels.presentation.composable.component.LevelButton

@Composable
fun LevelsScreen(
    levels: List<Level>,
    onUiAction: (LevelsViewModel.UiAction) -> Unit
) {
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
                onUiAction(LevelsViewModel.UiAction.LevelSelected(level))
            }
        }
    }
}
