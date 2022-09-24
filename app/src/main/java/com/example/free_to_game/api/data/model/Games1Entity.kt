package com.example.free_to_game.api.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Games1Entity")
data class Games1Entity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String = "",

    @ColumnInfo(name = "title")
    val title: String = "",

    @ColumnInfo(name = "game_url")
    val game_url: String = "",

    @ColumnInfo(name = "platform")
    val platform: String = "",

    @ColumnInfo(name = "publisher")
    val publisher: String = "",

    @ColumnInfo(name = "developer")
    val developer: String = "",

    @ColumnInfo(name = "release_date")
    val release_date: String = "",

    @ColumnInfo(name = "thumbnail")
    val thumbnail : String = "",

    @ColumnInfo(name = "short_description")
    val short_description : String = ""
)
