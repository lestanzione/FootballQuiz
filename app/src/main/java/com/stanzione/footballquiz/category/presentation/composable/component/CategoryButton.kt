package com.stanzione.footballquiz.category.presentation.composable.component

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.stanzione.footballquiz.category.data.model.Category
import com.stanzione.footballquiz.category.presentation.CategoriesViewModel
import com.stanzione.footballquiz.main.presentation.MainViewModel

@Composable
fun CategoryButton(
    category: Category,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick
    ) {
        Text(
            text = category.label,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
private fun CategoryButtonPreview() {
    CategoryButton(
        category = Category(1, "Categoria", enabled = true),
        modifier = Modifier,
        onClick = {}
    )
}