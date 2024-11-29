package com.stanzione.footballquiz.optionsgame.presentation.composable.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Header(
    currentQuestionNumber: Int,
    totalQuestionNumber: Int
) {
    Row(
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth()
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(
                    bottomStart = 24.dp,
                    bottomEnd = 24.dp
                )
            ),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = "$currentQuestionNumber / $totalQuestionNumber"
        )
    }
}

@Preview
@Composable
private fun HeaderPreview() {
    Header(
        currentQuestionNumber = 3,
        totalQuestionNumber = 10
    )
}