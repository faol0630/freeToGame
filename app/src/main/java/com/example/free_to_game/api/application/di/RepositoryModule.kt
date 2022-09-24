package com.example.free_to_game.api.application.di

import android.content.Context
import androidx.room.Room
import com.example.free_to_game.api.data.local.AppGamesDatabase
import com.example.free_to_game.api.data.local.GamesDao
import com.example.free_to_game.api.data.remote.APIGames
import com.example.free_to_game.api.data.remote.WebGamesService
import com.example.free_to_game.api.repository.RepositoryGames
import com.example.free_to_game.api.repository.RepositoryInt
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesWebGamesServices(): WebGamesService = APIGames.getGames()

    @Provides
    fun providesRepositoryGames(
        webGamesService: WebGamesService,
        appGamesDatabase: AppGamesDatabase
    ) : RepositoryGames = RepositoryGames(webGamesService,appGamesDatabase)

    @Provides
    fun providesRepositoryInt(
        repositoryGames: RepositoryGames
    ) : RepositoryInt = repositoryGames

    //Room -----------------------------------

    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context): AppGamesDatabase {
        return Room.databaseBuilder(context, AppGamesDatabase::class.java, "games_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesGamesDao(appGamesDatabase: AppGamesDatabase): GamesDao = appGamesDatabase.gamesDao()

}