package com.example.free_to_game.api.data.remote

import com.example.free_to_game.api.application.*
import com.example.free_to_game.api.data.model.Games1Entity
import retrofit2.http.GET

interface WebGamesService {


    @GET(ALL_GAMES)
    suspend fun getAllGames(): List<Games1Entity>

    @GET(BROWSER_GAMES)
    suspend fun getBrowserGames(): List<Games1Entity>

    @GET(PC_GAMES)
    suspend fun getPCGames(): List<Games1Entity>

    @GET(CATEGORY_SHOOTER)
    suspend fun getGameByCategoryShooter(): List<Games1Entity>

    @GET(CATEGORY_RACING)
    suspend fun getGameByCategoryRacing(): List<Games1Entity>

    @GET(CATEGORY_SUPERHERO)
    suspend fun getGameByCategorySuperhero(): List<Games1Entity>

    @GET(RELEASE_DATE)
    suspend fun getGamesByReleaseDate(): List<Games1Entity>

    @GET(ALPHABETICALLY)
    suspend fun getGamesAlphabetically(): List<Games1Entity>

    @GET(FLIGHT)
    suspend fun getGamesByCategoryFlight(): List<Games1Entity>

    @GET(ANIME)
    suspend fun getGamesByCategoryAnime(): List<Games1Entity>

    @GET(SCIFI)
    suspend fun getGamesByCategoryScifi(): List<Games1Entity>

}


//mmorpg, shooter, strategy, moba, racing, sports, social,
// sandbox, open-world, survival, pvp, pve, pixel, voxel,
// zombie, turn-based, first-person, third-Person, top-down,
// tank, space, sailing, side-scroller, superhero, permadeath,
// card, battle-royale, mmo, mmofps, mmotps, 3d, 2d, anime,
// fantasy, sci-fi, fighting, action-rpg, action, military,
// martial-arts, flight, low-spec, tower-defense, horror, mmorts


//sort by:
// https://www.freetogame.com/api/games?sort-by=alphabetical
//release-date, popularity, alphabetical or relevance
//sort alphabetically
