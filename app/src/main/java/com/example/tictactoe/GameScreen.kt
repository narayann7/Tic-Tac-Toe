package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.databinding.ActivityGameScreenBinding
import com.example.tictactoe.databinding.ActivityMainBinding

class GameScreen : AppCompatActivity() {


    private lateinit var binding: ActivityGameScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var bundel: Bundle? = intent.extras
        var player1 = bundel?.getString(
            "player1"
        )
        var player2 = bundel?.getString(
            "player2"
        )

        binding.player1.text = player1
        binding.player2.text = player2


    }
}