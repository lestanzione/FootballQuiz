package com.stanzione.footballquiz.optionsgame.presentation.composable.component

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun OptionButton(
    option: String
) {
    Button(onClick = {

    }) {
        Text(
            text = option,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}