package com.example.twentynine

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.twentynine.game.DeckManager
import com.example.twentynine.model.Player
import com.example.twentynine.ui.screens.GameScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val players = listOf(

            Player(1, "Player 1"),
            Player(2, "Player 2"),
            Player(3, "Player 3"),
            Player(4, "Player 4")
        )

        val deckManager = DeckManager()

        deckManager.dealCards(players)

        players.forEach {

            Log.d("CARD_GAME", "${it.name} -> ${it.hand}")
        }

        setContent {
            GameScreen(players)+
        }
    }
}