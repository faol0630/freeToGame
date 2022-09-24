package com.example.free_to_game.api.data.local

import androidx.room.*
import com.example.free_to_game.api.data.model.Games1Entity

@Dao
interface GamesDao {

    @Query("SELECT * FROM Games1Entity ORDER BY id ASC")
     suspend fun getAllFavoriteGames(): List<Games1Entity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertFavoriteGame(games1Entity: Games1Entity)

    @Delete
     suspend fun deleteFavoriteGame(games1Entity: Games1Entity)

}