package com.example.twentynine.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twentynine.model.Card as GameCard

@Composable
fun CardView(
    card: GameCard,
    onClick: () -> Unit = {}
) {

    Card(
        modifier = Modifier
            .width(70.dp)
            .height(100.dp)
            .padding(4.dp)
            .clickable {
                onClick()
            },

        shape = RoundedCornerShape(12.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(8.dp),

            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = card.rank.name,
                fontSize = 12.sp
            )

            Text(
                text = getSuitSymbol(card.suit.name),
                fontSize = 28.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

fun getSuitSymbol(suit: String): String {

    return when (suit) {

        "HEARTS" -> "♥"
        "DIAMONDS" -> "♦"
        "CLUBS" -> "♣"
        "SPADES" -> "♠"

        else -> ""
    }
}