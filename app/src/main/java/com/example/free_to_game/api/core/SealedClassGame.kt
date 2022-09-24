package com.example.free_to_game.api.core

import com.example.free_to_game.api.data.model.Game1

sealed class SealedClassGame{
    object Loading : SealedClassGame()
    data class Content(val gamesList: List<Game1>): SealedClassGame()
    object Error : SealedClassGame()
}
