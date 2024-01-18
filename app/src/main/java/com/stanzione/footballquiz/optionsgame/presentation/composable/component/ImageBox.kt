package com.stanzione.footballquiz.optionsgame.presentation.composable.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun ColumnScope.ImageBox(imageUrl: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .weight(5f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
//                                .data("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRl9WZZoHp9L7PktCD0MtwfZ3_Wtk_4MJnMjQ&usqp=CAU")
//                                .placeholder(R.drawable.placeholder_thumbnail_list_item)
//                                .error(R.drawable.placeholder_thumbnail_list_item)
//                                .fallback(R.drawable.placeholder_thumbnail_list_item)
                .build(),
            contentDescription = null
        )
    }
}