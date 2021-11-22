package com.example.tictactoe

import android.app.AlertDialog
import android.content.Context
import android.os.Parcelable
import android.view.View
import com.example.tictactoe.databinding.MatrixBinding
import kotlinx.android.parcel.Parcelize

@Parcelize
data class matchResult(
    var player1: String = "player1" ,
    var player2: String = "player2" ,
    var matrix: MutableList<Int> = mutableListOf() ,
    var status: Int = -1 ,
    //status == 1 -- player 1 won ,
    //status == 2 -- player 2 won ,
    //status == -1 -- draw,
) : Parcelable

fun valueArrayToList(
    valueArray: Array<Array<Int>>
): MutableList<Int> {
    var matrixList: MutableList<Int> = mutableListOf()

    for (i in valueArray)
        for (j in i)
            matrixList.add(j)

    return matrixList
}

fun matrixAsAleartDialog(context: Context , matrixList: MutableList<Int>) {
    var view = View.inflate(context , R.layout.matrix , null)
    var bb = AlertDialog.Builder(context)
    bb.setView(view)
    val dia = bb.create()
    dia.show()
    dia.window?.setBackgroundDrawableResource(android.R.color.transparent)
    var binding: MatrixBinding = MatrixBinding.bind(view)
    var buttonArray = arrayOf(
        binding.button1 , binding.button2 , binding.button3 ,
        binding.button4 , binding.button5 , binding.button6 ,
        binding.button7 , binding.button8 , binding.button9
    )
    var index = 0
    for (i in matrixList) {
        if (i == -1) {
            buttonArray[index].text = "-"
            index++
        } else {
            buttonArray[index].text = if (i == 1) "X" else "O"
            index++
        }
    }
}










