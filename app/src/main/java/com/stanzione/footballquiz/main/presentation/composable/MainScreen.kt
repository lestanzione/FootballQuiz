package com.stanzione.footballquiz.main.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.stanzione.footballquiz.main.data.model.Category

@Composable
fun MainScreen(categories: List<Category>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(categories.size) {index ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = categories[index].label)
                Text(text = categories[index].id.toString())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen(listOf())
}