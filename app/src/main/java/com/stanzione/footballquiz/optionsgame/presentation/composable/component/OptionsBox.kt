package com.stanzione.footballquiz.optionsgame.presentation.composable.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.stanzione.footballquiz.optionsgame.presentation.OptionsGameViewModel.UiAction

@Composable
fun ColumnScope.OptionsBox(
    optionList: List<String>,
    onUiAction: (UiAction) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .weight(3f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(optionList.size) { index ->
                OptionButton(
                    option = optionList[index],
                    onSelect = {
                        onUiAction(UiAction.SelectOption(index))
                    }
                )
            }
        }
    }
}