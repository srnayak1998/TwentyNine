package com.example.twentynine.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twentynine.ui.components.CardView
import com.example.twentynine.viewmodel.GameViewModel

@Composable
fun GameScreen(
    viewModel: GameViewModel
) {

    val currentPlayer =
        viewModel.players[viewModel.currentPlayerIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0B6623))
            .padding(16.dp)
    ) {

        Text(
            text = "29 Card Game",
            color = Color.White,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Current Turn: ${currentPlayer.name}",
            color = Color.White,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(40.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),

            contentAlignment = Alignment.Center
        ) {

            viewModel.playedCard?.let { played ->

                CardView(card = played)
            }
        }

        LazyRow {

            items(currentPlayer.hand) { card ->

                CardView(
                    card = card,

                    onClick = {

                        viewModel.playCard(card)
                    }
                )
            }
        }
    }
}