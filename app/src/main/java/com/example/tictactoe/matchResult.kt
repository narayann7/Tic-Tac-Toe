package com.example.tictactoe

import android.app.AlertDialog
import android.content.Context
import android.os.Parcelable
import android.view.View
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.tictactoe.databinding.MatrixBinding


data class matchResult(
    var player1: String = "player1" ,
    var player2: String = "player2" ,
    var matrix: String="",
    var status: Int = -1 ,
    //status == 1 -- player 1 won ,
    //status == 2 -- player 2 won ,
    //status == -1 -- draw,
)
@Entity(tableName = "matchResultEntityname")
data class MatchResultEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Long,
    var player1: String ,
    var player2: String ,
    var matrix: String ,
    var status: Int ,
    )


fun valueArrayToList(
    valueArray: Array<Array<Int>>
):String {
    var matrixString=""

    for (i in valueArray)
        for (j in i)
            if(j==-1)
                matrixString+='.'
            else
                matrixString+=j.toString()
    return matrixString
}

fun matrixAsAleartDialog(context: Context , matrixList: String) {
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
        if (i == '.') {
            buttonArray[index].text = "-"
            index++
        } else {
            buttonArray[index].text = if (i == '1') "X" else "O"
            index++
        }
    }
}










