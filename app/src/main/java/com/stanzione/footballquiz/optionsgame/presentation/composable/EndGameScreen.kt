package com.stanzione.footballquiz.optionsgame.presentation.composable

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun EndGameScreen(
    points: Int,
    onRestart: () -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "End game: $points")
        Spacer(modifier = Modifier.height(8.dp))
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