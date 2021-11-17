package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.tictactoe.databinding.ActivityGameScreenBinding
import com.example.tictactoe.databinding.ActivityMainBinding

class GameScreen : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityGameScreenBinding
    lateinit var buttonArray: Array<Array<Button>>
    lateinit var valueArray: Array<Array<Int>>
    private fun reset() {
        valueArray = arrayOf(
            arrayOf(-1, -1, -1),
            arrayOf(-1, -1, -1),
            arrayOf(-1, -1, -1),

            )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //picking up data from main Activity
        var bundel: Bundle? = intent.extras
        var player1 = bundel?.getString(
            "player1"
        )
        var player2 = bundel?.getString(
            "player2"
        )

        var currentPlayer: Boolean = true //true == X false == 0
        reset()

        buttonArray = arrayOf(
            arrayOf(binding.button1, binding.button2, binding.button3),
            arrayOf(binding.button4, binding.button5, binding.button6),
            arrayOf(binding.button7, binding.button8, binding.button9),
        )


        for (i in buttonArray)
            for (button in i)
                button.setOnClickListener(this)


    }

    override fun onClick(v: View?) {

        when (v) {
            binding.button1 -> {
            }
            binding.button2 -> {
            }
            binding.button3 -> {
            }
            binding.button4 -> {
            }
            binding.button5 -> {
            }
            binding.button6 -> {
            }
            binding.button7 -> {
            }
            binding.button8 -> {
            }
            binding.button9 -> {

            }
        }

    }
}