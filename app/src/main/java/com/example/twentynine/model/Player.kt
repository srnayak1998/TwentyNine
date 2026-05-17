package com.example.twentynine.model

data class Player(

    val id: Int,
    val name: String,

    val hand: MutableList<Card> = mutableListOf(),

    var score: Int = 0
)