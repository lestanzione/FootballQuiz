package com.stanzione.footballquiz.levels.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun UnlockLevelDialog(
    coinsToUnlock: Int,
    onDismiss: () -> Unit,
    onUnlock: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(
                    horizontal = 24.dp,
                    vertical = 16.dp,
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "This level is locked"
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "You can use your coins to unlock it now!"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = onUnlock) {
                    Text(
                        text = "Use $coinsToUnlock coins"
                    )
                }
                Button(onClick = onDismiss) {
                    Text(
                        text = "Cancel"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UnlockLevelDialogPreview() {
    UnlockLevelDialog(
        coinsToUnlock = 10,
        onDismiss = {},
        onUnlock = {}
    )
}
