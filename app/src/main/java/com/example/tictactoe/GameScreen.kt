package com.example.tictactoe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.tictactoe.databinding.ActivityGameScreenBinding

class GameScreen : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivityGameScreenBinding
    private lateinit var buttonArray: Array<Array<Button>>
    private lateinit var valueArray: Array<Array<Int>>
    private var currentPlayer: Boolean = true //true == X false == 0
    private lateinit var player1: String
    private lateinit var player2: String
    private var totalTurn: Int = 9
    private var p1count = 0
    private var p2count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameScreenBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        buttonArray = arrayOf(
            arrayOf(binding.button1 , binding.button2 , binding.button3) ,
            arrayOf(binding.button4 , binding.button5 , binding.button6) ,
            arrayOf(binding.button7 , binding.button8 , binding.button9) ,
        )
        //picking up data from main Activity
        val bundle: Bundle? = intent.extras
        player1 = bundle?.getString(
            "player1"
        ).toString()

        player2 = bundle?.getString(
            "player2"
        ).toString()

      binding.player1.text=player1
      binding.player2.text=player2

        @SuppressLint("SetTextI18n")
        fun reset() {
            binding.resultText.text = "$player1's turn "
            valueArray = arrayOf(
                arrayOf(-1 , -1 , -1) ,
                arrayOf(-1 , -1 , -1) ,
                arrayOf(-1 , -1 , -1) ,
            )
            for (i in buttonArray)
                for (button in i) {
                    button.setOnClickListener(this)
                    button.isEnabled = true
                    button.text = ""
                }
        }

        binding.history.setOnClickListener {
            val intent: Intent = Intent(this , MatchHistorys::class.java)

            startActivity(intent)
        }
        reset()

        binding.reset.setOnClickListener {
            reset()
        }
    }

    fun checkWinner(): Pair<Boolean , String> {
        var result: Pair<Boolean , String> = Pair(false , "")

        for (i in 0..2) {
            if (valueArray[i][0] == valueArray[i][1] && valueArray[i][0] == valueArray[i][2]) {
                if (valueArray[i][0] == 1) {
                    result = result.copy(first = true , second = "X")
                    return result
                } else if (valueArray[i][0] == 0) {
                    result = result.copy(first = true , second = "O")
                    return result
                }
            }
        }

        for (i in 0..2) {
            if (valueArray[0][i] == valueArray[1][i] && valueArray[0][i] == valueArray[2][i]) {
                if (valueArray[0][i] == 1) {
                    result = result.copy(first = true , second = "X")
                    return result
                } else if (valueArray[0][i] == 0) {
                    result = result.copy(first = true , second = "O")
                    return result
                }
            }
        }


        if (valueArray[0][0] == valueArray[1][1] && valueArray[0][0] == valueArray[2][2]) {
            if (valueArray[0][0] == 1) {
                result = result.copy(first = true , second = "X")
            } else if (valueArray[0][0] == 0) {
                result = result.copy(first = true , second = "O")
            }
        }

        if (valueArray[0][2] == valueArray[1][1] && valueArray[0][2] == valueArray[2][0]) {
            if (valueArray[0][2] == 1) {
                result = result.copy(first = true , second = "X")
            } else if (valueArray[0][2] == 0) {
                result = result.copy(first = true , second = "O")
            }
        }
        return result
    }

    private fun disableAllButton() {
        for (i in buttonArray)
            for (button in i) {
                button.isEnabled = false
            }
    }
    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when (v) {
            binding.button1 -> {
                updateIt(0 , 0 , currentPlayer)
            }
            binding.button2 -> {
                updateIt(0 , 1 , currentPlayer)
            }
            binding.button3 -> {
                updateIt(0 , 2 , currentPlayer)
            }
            binding.button4 -> {
                updateIt(1 , 0 , currentPlayer)
            }
            binding.button5 -> {
                updateIt(1 , 1 , currentPlayer)
            }
            binding.button6 -> {
                updateIt(1 , 2 , currentPlayer)
            }
            binding.button7 -> {
                updateIt(2 , 0 , currentPlayer)
            }
            binding.button8 -> {
                updateIt(2 , 1 , currentPlayer)
            }
            binding.button9 -> {
                updateIt(2 , 2 , currentPlayer)
            }
        }
        currentPlayer = !currentPlayer
        totalTurn--
        val result = checkWinner()
        var matchResult:matchResult= matchResult(
            player1=binding.player1.text.toString(),
            player2=binding.player2.text.toString(),
        )
        if (totalTurn != 0 || result.first) {

            if (result.first) {


                if (result.second == "X") {
                    binding.resultText.text = "$player1 won "
                    p1count++
                    matchResult.status=1
                    binding.score1.text = p1count.toString()
                } else {
                    binding.resultText.text = "$player2 won"
                    p2count++
                    matchResult.status=2
                    binding.score2.text = p2count.toString()
                }

                disableAllButton()
                matchResult.matrix= valueArrayToList(valueArray)
                totalTurn = 9
            } else {
                binding.resultText.text =
                    if (currentPlayer) "$player1's turn " else "$player2's turn"
            }
            Log.i("x1",matchResult.player1)
            Log.i("x2",matchResult.player2)
            Log.i("x3",matchResult.status.toString())
            Log.i("x4",matchResult.matrix.toString())

        } else {
            if (!result.first)
            {
                binding.resultText.text = "Its a draw"
                matchResult.status=-1
                matchResult.matrix= valueArrayToList(valueArray)
                Log.i("x1",matchResult.player1)
                Log.i("x2",matchResult.player2)
                Log.i("x3",matchResult.status.toString())
                Log.i("x4",matchResult.matrix.toString())

            }
            totalTurn = 9
        }
    }

    private fun updateIt(i: Int , j: Int , currentPlayer: Boolean) {
        //X ==1 , O == 0 in value array
        buttonArray[i][j].apply {
            text = if (currentPlayer) "X" else "O"
            isEnabled = false
        }
        valueArray[i][j] = if (currentPlayer) 1 else 0
    }
}