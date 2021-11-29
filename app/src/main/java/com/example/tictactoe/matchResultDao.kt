package com.example.tictactoe

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface matchResultDao {

    @Insert
     fun insertResult(matchResultEntity : MatchResultEntity)

    @Delete
    fun deleteResult(matchResultEntity: MatchResultEntity)

    @Query("Select *from matchResultEntityname")
     fun getAllMatchResult():List<MatchResultEntity>
    @Query("DELETE FROM matchResultEntityname")
    fun delete()
}