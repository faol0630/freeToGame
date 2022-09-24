package com.example.free_to_game.api.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game1(
    var id : String = "",
    var title : String = "",
    var game_url : String = "",
    var platform : String = "",
    var publisher : String = "",
    var developer : String = "",
    var release_date : String = "",
    var thumbnail : String = "",
    var short_description : String = ""
) : Parcelable

