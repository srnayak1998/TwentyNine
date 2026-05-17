package com.example.twentynine.model

enum class Suit {
    HEARTS,
    DIAMONDS,
    CLUBS,
    SPADES
}

enum class Rank(val points: Int) {

    JACK(3),
    NINE(2),
    ACE(1),
    TEN(1),
    KING(0),
    QUEEN(0),
    EIGHT(0),
    SEVEN(0)
}

data class Card(
    val suit: Suit,
    val rank: Rank
)