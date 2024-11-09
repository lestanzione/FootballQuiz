package com.stanzione.footballquiz.main.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stanzione.footballquiz.main.presentation.MainViewModel

@Composable
fun MainScreen(
    onUiAction: (MainViewModel.UiAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                onUiAction(MainViewModel.UiAction.PlayGameSelected)
            }
        ) {
            Text(
                text = "Play"
            )
        }

        Button(
            onClick = {
                onUiAction(MainViewModel.UiAction.PlayGameSelected)
            }
        ) {
            Text(
                text = "Missions"
            )
        }

        Button(
            onClick = {
                onUiAction(MainViewModel.UiAction.PlayGameSelected)
            }
        ) {
            Text(
                text = "Shop"
            )
        }

        Button(
            onClick = {
                onUiAction(MainViewModel.UiAction.PlayGameSelected)
            }
        ) {
            Text(
                text = "Settings"
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen({})
}