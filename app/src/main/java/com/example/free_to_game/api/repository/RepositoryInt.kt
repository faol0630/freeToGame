package com.example.free_to_game.api.repository

import com.example.free_to_game.api.data.model.Game1
import com.example.free_to_game.api.data.model.Games1Entity

interface RepositoryInt {
    suspend fun getAllGames():List<Game1>
    suspend fun getBrowserGames():List<Game1>
    suspend fun getPCGames():List<Game1>
    suspend fun getShooterGames():List<Game1>
    suspend fun getRacingGames():List<Game1>
    suspend fun getSuperheroGames():List<Game1>
    suspend fun getGamesByReleaseDate():List<Game1>
    suspend fun getGamesAlphabetically():List<Game1>
    suspend fun getFlightGames():List<Game1>
    suspend fun getAnimeGames():List<Game1>
    suspend fun getScifiGames():List<Game1>
    //room:
    suspend fun getAllFavoriteGamesRepo(): List<Games1Entity>
    suspend fun insertFavoriteGamesRepo(game: Games1Entity)
    suspend fun deleteFavoriteGamesRepo(game: Games1Entity)

}