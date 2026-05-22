package com.example.twentynine.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.twentynine.model.Card
import com.example.twentynine.model.Player

class GameViewModel : ViewModel() {

    val players = mutableStateListOf<Player>()

    var currentPlayerIndex by mutableStateOf(0)

    var playedCard by mutableStateOf<Card?>(null)

    fun setupPlayers(playerList: List<Player>) {

        if (players.isEmpty()) {

            players.addAll(playerList)
        }
    }

    fun playCard(card: Card) {

        val currentPlayer = players[currentPlayerIndex]

        currentPlayer.hand.remove(card)

        playedCard = card

        currentPlayerIndex =
            (currentPlayerIndex + 1) % players.size
    }
}