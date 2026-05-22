package com.example.twentynine.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twentynine.model.Card
import com.example.twentynine.model.Player
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

    val players = mutableStateListOf<Player>()

    var currentPlayerIndex by mutableIntStateOf(0)

    val playedCards =
        mutableStateListOf<Pair<Int, Card>>()

    var leadSuit by mutableStateOf<String?>(null)

    var message by mutableStateOf("")

    fun setupPlayers(playerList: List<Player>) {

        if (players.isEmpty()) {

            players.addAll(playerList)
        }
    }

    fun playCard(card: Card) {

        val currentPlayer =
            players[currentPlayerIndex]

        // FOLLOW SUIT VALIDATION

        if (leadSuit != null) {

            val hasLeadSuit =
                currentPlayer.hand.any {

                    it.suit.name == leadSuit
                }

            if (
                hasLeadSuit &&
                card.suit.name != leadSuit
            ) {

                message =
                    "You must follow suit!"

                return
            }
        }

        currentPlayer.hand.remove(card)

        playedCards.add(
            Pair(currentPlayerIndex, card)
        )

        if (playedCards.size == 1) {

            leadSuit = card.suit.name
        }

        currentPlayerIndex =
            (currentPlayerIndex + 1) %
                    players.size

        if (playedCards.size == 4) {

            calculateWinner()
        }
    }

    private fun calculateWinner() {

        var winningPair = playedCards[0]

        for (played in playedCards) {

            val currentCard = played.second
            val winningCard = winningPair.second

            if (
                currentCard.suit ==
                winningCard.suit &&
                currentCard.rank.power >
                winningCard.rank.power
            ) {

                winningPair = played
            }
        }

        val winnerIndex = winningPair.first

        val winnerPlayer =
            players[winnerIndex]

        val trickPoints =
            playedCards.sumOf {

                it.second.rank.points
            }

        message =
            "${winnerPlayer.name} won trick (+$trickPoints points)"

        currentPlayerIndex = winnerIndex

        viewModelScope.launch {

            delay(2500)

            playedCards.clear()

            leadSuit = null

            message = ""
        }
    }
}