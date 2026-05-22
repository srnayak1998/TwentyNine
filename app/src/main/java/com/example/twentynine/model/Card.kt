package com.example.twentynine.model

enum class Suit {
    HEARTS,
    DIAMONDS,
    CLUBS,
    SPADES
}

enum class Rank(
    val points: Int,
    val power: Int
) {

    JACK(3, 8),
    NINE(2, 7),
    ACE(1, 6),
    TEN(1, 5),
    KING(0, 4),
    QUEEN(0, 3),
    EIGHT(0, 2),
    SEVEN(0, 1)
}

data class Card(
    val suit: Suit,
    val rank: Rank
)