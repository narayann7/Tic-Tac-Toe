package com.example.tictactoe

data class matchResult(
    val player1: String ,
    val player2: String ,
    val matrix: List<Int> ,
    val status: Int ,
    //status == 1 -- player 1 won ,
    //status == 2 -- player 2 won ,
    //status == -1 -- draw,
)