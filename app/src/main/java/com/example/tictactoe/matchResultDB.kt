package com.example.tictactoe

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [MatchResultEntity::class], version = 1, exportSchema = false)
abstract  class MatchResultDB : RoomDatabase() {
    abstract fun matchResultDao(): matchResultDao

}