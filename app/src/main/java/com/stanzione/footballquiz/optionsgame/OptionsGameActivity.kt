package com.stanzione.footballquiz.optionsgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.stanzione.footballquiz.main.data.model.Category
import com.stanzione.footballquiz.main.presentation.MainViewModel
import com.stanzione.footballquiz.main.presentation.composable.component.CategoryButton
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
                    Options()
                }

            }

        }
    }
}

@Composable
private fun ColumnScope.Options() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)
            .weight(3f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val options = listOf(
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4"
        )

        LazyVerticalGrid(
            modifier = Modifier
                .background(Color.Magenta),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(options.size) { index ->
                OptionButton(
                    option = options[index]
                )
            }
        }
    }
}

@Composable
private fun OptionButton(
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