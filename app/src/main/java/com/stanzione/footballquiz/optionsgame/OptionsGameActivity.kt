package com.stanzione.footballquiz.optionsgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.stanzione.footballquiz.ui.theme.FootballQuizTheme

class OptionsGameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            FootballQuizTheme {
                Text(text = "Options Game Activity")
            }

        }
    }
}