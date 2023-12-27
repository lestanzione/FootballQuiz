package com.stanzione.footballquiz.optionsgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.stanzione.footballquiz.ui.theme.FootballQuizTheme

class OptionsGameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            FootballQuizTheme {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red)
                ) {
                    Text(text = "Options Game Activity")
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Blue)
                            .weight(5f)
                    ) {
                        Text(text = "Image block")
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Green)
                            .weight(3f)
                    ) {
                        Text(text = "Options block")
                    }
                }

            }

        }
    }
}