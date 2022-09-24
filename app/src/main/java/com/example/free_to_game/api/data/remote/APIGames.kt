package com.example.free_to_game.api.data.remote

import com.example.free_to_game.api.application.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIGames {
    companion object{
        fun getGames(): WebGamesService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(WebGamesService::class.java)
        }
    }
}
