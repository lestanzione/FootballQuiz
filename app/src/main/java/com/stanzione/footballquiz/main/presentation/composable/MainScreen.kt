package com.stanzione.footballquiz.main.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stanzione.footballquiz.main.data.model.Category
import com.stanzione.footballquiz.main.presentation.composable.component.CategoryButton

@Composable
fun MainScreen(categories: List<Category>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories.size) { index ->
            CategoryButton(
                category = categories[index],
                onUiAction = {}
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen(listOf())
}