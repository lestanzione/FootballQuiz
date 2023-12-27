package com.stanzione.footballquiz.optionsgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
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
                    Image()
                    Title()
                    Options()
                }

            }

        }
    }
}

@Composable
private fun ColumnScope.Image() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
            .weight(5f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjCjgVv-4Cl9Z-XQT3uCV_KKtjPzSNG-q2XA&usqp=CAU")
//                                .data("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRl9WZZoHp9L7PktCD0MtwfZ3_Wtk_4MJnMjQ&usqp=CAU")
//                                .placeholder(R.drawable.placeholder_thumbnail_list_item)
//                                .error(R.drawable.placeholder_thumbnail_list_item)
//                                .fallback(R.drawable.placeholder_thumbnail_list_item)
                .build(),
            contentDescription = null
        )
    }
}

@Composable
private fun Title() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray),
        text = "Quem é esse jogador?",
        fontSize = 20.sp,
        textAlign = TextAlign.Center
    )
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
            "Cristiano Ronaldo",
            "Messi",
            "Mbappé",
            "Rony"
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