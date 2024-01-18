package com.stanzione.footballquiz.optionsgame.presentation.composable.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun Title(title: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth(),
        text = title,
        fontSize = 20.sp,
        textAlign = TextAlign.Center
    )
}