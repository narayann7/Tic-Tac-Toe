package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.tictactoe.databinding.ActivityMatchHistorysBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MatchHistorys : AppCompatActivity() {
    private lateinit var binding: ActivityMatchHistorysBinding
    private lateinit var recyclerHistory: recyclerHistory
    private lateinit var matchResultDB: MatchResultDB
    lateinit var historyList: MutableList<matchResult>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchHistorysBinding.inflate(layoutInflater)
        setContentView(binding.root)

historyList= mutableListOf()
        matchResultDB = Room.databaseBuilder(
            applicationContext , MatchResultDB::class.java ,
            "matchResultDB"
        ).build()

        GlobalScope.launch {
            getx()
        }

        binding.rvHistory.layoutManager = LinearLayoutManager(this)
        recyclerHistory = recyclerHistory(historyList , this)
        binding.rvHistory.adapter = recyclerHistory
    }

    private suspend fun getx() {
        var listx = matchResultDB.matchResultDao().getAllMatchResult()

        for (i in listx) {
            historyList.add(
                matchResult(
                    i.player1 ,
                    i.player2 ,
                    i.matrix ,
                    i.status
                )
            )
        }
    }
}