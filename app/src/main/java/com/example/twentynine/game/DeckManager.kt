package com.example.twentynine.game

import com.example.twentynine.model.Card
import com.example.twentynine.model.Player
import com.example.twentynine.model.Rank
import com.example.twentynine.model.Suit

class DeckManager {

    private val deck = mutableListOf<Card>()

    init {
        createDeck()
    }

    private fun createDeck() {

        for (suit in Suit.values()) {

            for (rank in Rank.values()) {

                deck.add(Card(suit, rank))
            }
        }
    }

    fun shuffleDeck() {
        deck.shuffle()
    }

    fun dealCards(players: List<Player>) {

        shuffleDeck()

        repeat(8) {

            players.forEach { player ->

                player.hand.add(deck.removeAt(0))
            }
        }
    }
}