package com.stanzione.footballquiz.category.presentation.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stanzione.footballquiz.category.data.model.Category
import com.stanzione.footballquiz.category.presentation.CategoriesViewModel
import com.stanzione.footballquiz.category.presentation.composable.component.CategoryButton

@Composable
fun CategoriesScreen(
    categories: List<Category>,
    onUiAction: (CategoriesViewModel.UiAction) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(categories) { category ->
            CategoryButton(
                category = category,
                modifier = Modifier.fillMaxWidth(),
            ) {
                onUiAction(CategoriesViewModel.UiAction.CategorySelected(category))
            }
        }
    }
}
