package com.example.tictactoe

data class matchResult(
    var player1: String = "player1" ,
    var player2: String = "player2" ,
    var matrix: MutableList<Int> = mutableListOf() ,
    var status: Int = -1 ,
    //status == 1 -- player 1 won ,
    //status == 2 -- player 2 won ,
    //status == -1 -- draw,
)

fun valueArrayToList(
    valueArray: Array<Array<Int>>
): MutableList<Int> {
  var matrixList: MutableList<Int> = mutableListOf()

    for (i in valueArray)
        for (j in i)
            matrixList.add(j)

    return matrixList
}