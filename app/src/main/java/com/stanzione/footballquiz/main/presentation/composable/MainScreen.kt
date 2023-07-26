package com.stanzione.footballquiz.main.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen() {
    val numbers = (0..19).toList()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(numbers.size) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Number")
                Text(text = "$it")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen()
}