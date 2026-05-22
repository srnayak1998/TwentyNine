package com.example.twentynine.viewmodel

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.twentynine.model.Card
import com.example.twentynine.model.Player

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

    val players = mutableStateListOf<Player>()

    var currentPlayerIndex by mutableIntStateOf(0)

    val playedCards = mutableStateListOf<Pair<String, Card>>()

    fun setupPlayers(playerList: List<Player>) {

        if (players.isEmpty()) {

            players.addAll(playerList)
        }
    }

    fun playCard(card: Card) {

        val currentPlayer = players[currentPlayerIndex]

        currentPlayer.hand.remove(card)

        playedCards.add(
            Pair(currentPlayer.name, card)
        )

        currentPlayerIndex =
            (currentPlayerIndex + 1) % players.size

        if (playedCards.size == 4) {

            viewModelScope.launch {

                delay(2000)

                clearTable()
            }
        }
    }

    private fun clearTable() {

        playedCards.clear()
    }
}