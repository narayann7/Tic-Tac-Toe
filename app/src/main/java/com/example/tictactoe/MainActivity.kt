package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.history.setOnClickListener {
            val intent2: Intent = Intent(this , MatchHistorys::class.java)

            startActivity(intent2)
        }

        binding.startButton.setOnClickListener {
            var p1 = binding.player1.text.toString()
            var p2 = binding.player2.text.toString()

            p1=p1.trim()
            p2=p2.trim()

            if(p1.isNotEmpty() && p2.isNotEmpty())
            {
                val intent = Intent(this , GameScreen::class.java)

                intent.putExtra("player1" , p1)
                intent.putExtra("player2" , p2)
                startActivity(
                    intent
                )
            }
        }
    }
}
