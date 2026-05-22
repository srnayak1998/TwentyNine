package com.example.twentynine.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = viewModel.message,
            color = Color.Yellow,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Played Cards",
                color = Color.White,
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyRow {

                items(viewModel.playedCards) { played ->

                    Column(
                        horizontalAlignment =
                            Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "Player ${played.first + 1}",
                            color = Color.White
                        )

                        CardView(card = played.second)
                    }

                    Spacer(
                        modifier = Modifier.width(12.dp)
                    )
                }
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