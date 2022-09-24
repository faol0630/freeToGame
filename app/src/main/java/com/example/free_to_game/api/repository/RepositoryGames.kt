package com.example.free_to_game.api.repository

import com.example.free_to_game.api.data.local.AppGamesDatabase
import com.example.free_to_game.api.data.model.Game1
import com.example.free_to_game.api.data.model.Games1Entity
import com.example.free_to_game.api.data.remote.WebGamesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryGames @Inject constructor(
    private val apiGetGames: WebGamesService,
    private val appGamesDatabase: AppGamesDatabase
) : RepositoryInt {

    override suspend fun getAllGames():List<Game1>{
        return withContext(Dispatchers.IO){
            apiGetGames.getAllGames().map {
                Game1(
                    it.id,
                    it.title,
                    it.game_url,
                    it.platform,
                    it.publisher,
                    it.developer,
                    it.release_date,
                    it.thumbnail,
                    it.short_description
                )
            }
        }
    }

    override suspend fun getBrowserGames():List<Game1>{
        return withContext(Dispatchers.IO){
            apiGetGames.getBrowserGames().map {
                Game1(
                    it.id,
                    it.title,
                    it.game_url,
                    it.platform,
                    it.publisher,
                    it.developer,
                    it.release_date,
                    it.thumbnail,
                    it.short_description
                )
            }
        }
    }
    override suspend fun getPCGames():List<Game1>{
        return withContext(Dispatchers.IO){
            apiGetGames.getPCGames().map {
                Game1(
                    it.id,
                    it.title,
                    it.game_url,
                    it.platform,
                    it.publisher,
                    it.developer,
                    it.release_date,
                    it.thumbnail,
                    it.short_description
                )
            }
        }
    }
    override suspend fun getShooterGames():List<Game1>{
        return withContext(Dispatchers.IO){
            apiGetGames.getGameByCategoryShooter().map {
                Game1(
                    it.id,
                    it.title,
                    it.game_url,
                    it.platform,
                    it.publisher,
                    it.developer,
                    it.release_date,
                    it.thumbnail,
                    it.short_description
                )
            }
        }
    }
    override suspend fun getRacingGames():List<Game1>{
        return withContext(Dispatchers.IO){
            apiGetGames.getGameByCategoryRacing().map {
                Game1(
                    it.id,
                    it.title,
                    it.game_url,
                    it.platform,
                    it.publisher,
                    it.developer,
                    it.release_date,
                    it.thumbnail,
                    it.short_description
                )
            }
        }
    }
    override suspend fun getSuperheroGames():List<Game1>{
        return withContext(Dispatchers.IO){
            apiGetGames.getGameByCategorySuperhero().map {
                Game1(
                    it.id,
                    it.title,
                    it.game_url,
                    it.platform,
                    it.publisher,
                    it.developer,
                    it.release_date,
                    it.thumbnail,
                    it.short_description
                )
            }
        }
    }
    override suspend fun getGamesByReleaseDate():List<Game1>{
        return withContext(Dispatchers.IO){
            apiGetGames.getGamesByReleaseDate().map {
                Game1(
                    it.id,
                    it.title,
                    it.game_url,
                    it.platform,
                    it.publisher,
                    it.developer,
                    it.release_date,
                    it.thumbnail,
                    it.short_description
                )
            }
        }
    }
    override suspend fun getGamesAlphabetically():List<Game1>{
        return withContext(Dispatchers.IO){
            apiGetGames.getGamesAlphabetically().map {
                Game1(
                    it.id,
                    it.title,
                    it.game_url,
                    it.platform,
                    it.publisher,
                    it.developer,
                    it.release_date,
                    it.thumbnail,
                    it.short_description
                )
            }
        }
    }

    override suspend fun getFlightGames():List<Game1>{
        return withContext(Dispatchers.IO){
            apiGetGames.getGamesByCategoryFlight().map {
                Game1(
                    it.id,
                    it.title,
                    it.game_url,
                    it.platform,
                    it.publisher,
                    it.developer,
                    it.release_date,
                    it.thumbnail,
                    it.short_description
                )
            }
        }
    }

    override suspend fun getAnimeGames():List<Game1>{
        return withContext(Dispatchers.IO){
            apiGetGames.getGamesByCategoryAnime().map {
                Game1(
                    it.id,
                    it.title,
                    it.game_url,
                    it.platform,
                    it.publisher,
                    it.developer,
                    it.release_date,
                    it.thumbnail,
                    it.short_description
                )
            }
        }
    }

    override suspend fun getScifiGames():List<Game1>{
        return withContext(Dispatchers.IO){
            apiGetGames.getGamesByCategoryScifi().map {
                Game1(
                    it.id,
                    it.title,
                    it.game_url,
                    it.platform,
                    it.publisher,
                    it.developer,
                    it.release_date,
                    it.thumbnail,
                    it.short_description
                )
            }
        }
    }


    //ROOM:

    override suspend fun getAllFavoriteGamesRepo(): List<Games1Entity> {
        return withContext(Dispatchers.IO){
            appGamesDatabase.gamesDao().getAllFavoriteGames()
        }
    }

    override suspend fun insertFavoriteGamesRepo(game: Games1Entity){
        return withContext(Dispatchers.IO){
            appGamesDatabase.gamesDao().insertFavoriteGame(game)
        }
    }
    override suspend fun deleteFavoriteGamesRepo(game: Games1Entity){
        return withContext(Dispatchers.IO){
            appGamesDatabase.gamesDao().deleteFavoriteGame(game)
        }
    }


}
