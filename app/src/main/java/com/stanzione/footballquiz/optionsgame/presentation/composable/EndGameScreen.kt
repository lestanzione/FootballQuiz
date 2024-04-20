package com.stanzione.footballquiz.optionsgame.presentation.composable

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stanzione.footballquiz.R

@Composable
fun EndGameScreen(
    points: Int,
    totalQuestionNumber: Int,
    onRestart: () -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_trophy1),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Text(
            text = "Congratulations",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "$points / $totalQuestionNumber",
            fontSize = 32.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                (context as Activity).finish()
            }
        ) {
            Text(text = "Back")
        }
        Button(onClick = {
            onRestart()
        }) {
            Text(text = "Restart")
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun EndGameScreenPreview() {
    EndGameScreen(
        points = 0,
        totalQuestionNumber = 0,
        onRestart = {}
    )
}