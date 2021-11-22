package com.example.tictactoe

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tictactoe.databinding.MatchResultItemBinding
import com.example.tictactoe.databinding.MatrixBinding

class recyclerHistory(
    var historyList: MutableList<matchResult> ,
    var context: Context
) : RecyclerView.Adapter<recyclerHistory.HistoryViewHolder>() {
    inner class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val player1: TextView = itemView.findViewById(R.id.hp1)
        val player2: TextView = itemView.findViewById(R.id.hp2)
        val status: TextView = itemView.findViewById(R.id.hstatus)
        var button: Button = itemView.findViewById(R.id.hresult)
    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): HistoryViewHolder {
        var itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.match_result_item , parent , false)

        return HistoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder , position: Int) {
        var currentItem = historyList[position]

        holder.player1.text = currentItem.player1.toString()
        holder.player2.text = currentItem.player2.toString()
        holder.status.text = currentItem.status.toString()


        holder.button.setOnClickListener {
            matrixAsAleartDialog(context , currentItem.matrix)
        }
    }

    override fun getItemCount(): Int {
        return historyList.size
    }
}