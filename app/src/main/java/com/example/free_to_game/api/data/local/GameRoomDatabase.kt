package com.example.free_to_game.api.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.free_to_game.api.data.model.Games1Entity


@Database(entities = [Games1Entity::class], version = 2)
abstract class AppGamesDatabase : RoomDatabase() {
    abstract fun gamesDao(): GamesDao
}
