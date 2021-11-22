package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tictactoe.databinding.ActivityMatchHistorysBinding

class MatchHistorys : AppCompatActivity() {
    private lateinit var binding: ActivityMatchHistorysBinding
    private lateinit var recyclerHistory: recyclerHistory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchHistorysBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var historyList: MutableList<matchResult> = mutableListOf()

        historyList.add(
            matchResult(
                "lx" , "skillz " , mutableListOf(
                    1 , -1 , 1 ,
                    1 , 0 , 1 ,
                    -1 , 0 , 1
                ) , status = 2
            )
        )
        historyList.add(
            matchResult(
                "lx2" , "skillz2 " , mutableListOf(
                    -1 , 1 , 1 ,
                    0 , -1 , 1 ,
                    0 , 0 , -1
                ) , status = 1
            )
        )
        historyList.add(
            matchResult(
                "lx3" , "skillz3 " , mutableListOf(
                    1 , 1 , 1 ,
                    1 , 1 , 1 ,
                    1 , 1 , 1
                ) , status = 2
            )
        )
        historyList.add(
            matchResult(
                "lx4" , "skillz4 " , mutableListOf(
                    1 , 1 , 1 ,
                    1 , 1 , 1 ,
                    1 , 1 , 1
                ) , status = 2
            )
        )

        binding.rvHistory.layoutManager= LinearLayoutManager(this)
        recyclerHistory=recyclerHistory(historyList,this)
        binding.rvHistory.adapter=recyclerHistory


    }
}