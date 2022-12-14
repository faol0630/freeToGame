package com.example.free_to_game.api.presentation

import androidx.lifecycle.*
import com.example.free_to_game.api.core.SealedClassGame
import com.example.free_to_game.api.data.model.Game1
import com.example.free_to_game.api.data.model.Games1Entity
import com.example.free_to_game.api.repository.RepositoryInt
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelGame @Inject constructor(
    private val repositoryInt: RepositoryInt
) :ViewModel() {

    private val _updatingSealedGame = MutableLiveData<SealedClassGame>()
    val updatinSealedGame: LiveData<SealedClassGame>
        get() = _updatingSealedGame

    fun getAllGamesVM() {
        viewModelScope.launch {
            _updatingSealedGame.postValue(SealedClassGame.Loading)

            try {
                val allGames = repositoryInt.getAllGames()
                _updatingSealedGame.postValue(SealedClassGame.Content(allGames))
            }catch (e: Exception){
                _updatingSealedGame.postValue(SealedClassGame.Error)
            }
        }
    }

    fun getBrowserGamesVM() {
        viewModelScope.launch {
            _updatingSealedGame.postValue(SealedClassGame.Loading)

            try {
                val browserGames = repositoryInt.getBrowserGames()
                _updatingSealedGame.postValue(SealedClassGame.Content(browserGames))
            }catch (e: Exception){
                _updatingSealedGame.postValue(SealedClassGame.Error)
            }
        }
    }

    fun getPCGamesVM() {
        viewModelScope.launch {
            _updatingSealedGame.postValue(SealedClassGame.Loading)

            try {
                val pcGames = repositoryInt.getPCGames()
                _updatingSealedGame.postValue(SealedClassGame.Content(pcGames))
            }catch (e: Exception){
                _updatingSealedGame.postValue(SealedClassGame.Error)
            }
        }
    }

    fun getShooterGamesVM() {
        viewModelScope.launch {
            _updatingSealedGame.postValue(SealedClassGame.Loading)

            try {
                val shooterGames = repositoryInt.getShooterGames()
                _updatingSealedGame.postValue(SealedClassGame.Content(shooterGames))
            }catch (e: Exception){
                _updatingSealedGame.postValue(SealedClassGame.Error)
            }


        }
    }

    fun getRacingGamesVM() {
        viewModelScope.launch {
            _updatingSealedGame.postValue(SealedClassGame.Loading)

            try {
                val racingGames = repositoryInt.getRacingGames()
                _updatingSealedGame.postValue(SealedClassGame.Content(racingGames))
            }catch (e: Exception){
                _updatingSealedGame.postValue(SealedClassGame.Error)
            }

        }
    }

    fun getSuperheroGamesVM() {
        viewModelScope.launch {
            _updatingSealedGame.postValue(SealedClassGame.Loading)

            try {
                val superheroGames = repositoryInt.getSuperheroGames()
                _updatingSealedGame.postValue(SealedClassGame.Content(superheroGames))
            }catch (e: Exception){
                _updatingSealedGame.postValue(SealedClassGame.Error)
            }

        }
    }

    fun getGamesByReleaseDateVM() {
        viewModelScope.launch {
            _updatingSealedGame.postValue(SealedClassGame.Loading)

            try {
                val gamesByReleaseDate = repositoryInt.getGamesByReleaseDate()
                _updatingSealedGame.postValue(SealedClassGame.Content(gamesByReleaseDate))
            }catch (e: Exception){
                _updatingSealedGame.postValue(SealedClassGame.Error)
            }
        }
    }

    fun getGamesAlphabeticallyVM() {
        viewModelScope.launch {
            _updatingSealedGame.postValue(SealedClassGame.Loading)

            try {
                val gamesAlphabetically = repositoryInt.getGamesAlphabetically()
                _updatingSealedGame.postValue(SealedClassGame.Content(gamesAlphabetically))
            }catch (e: Exception){
                _updatingSealedGame.postValue(SealedClassGame.Error)
            }

        }
    }

    fun getFlightGamesVM() {
        viewModelScope.launch {
            _updatingSealedGame.postValue(SealedClassGame.Loading)

            try {
                val flightGames = repositoryInt.getFlightGames()
                _updatingSealedGame.postValue(SealedClassGame.Content(flightGames))
            }catch (e: Exception){
                _updatingSealedGame.postValue(SealedClassGame.Error)
            }

        }
    }

    fun getAnimeGamesVM() {
        viewModelScope.launch {
            _updatingSealedGame.postValue(SealedClassGame.Loading)

            try {
                val animeGames = repositoryInt.getAnimeGames()
                _updatingSealedGame.postValue(SealedClassGame.Content(animeGames))
            }catch (e: Exception){
                _updatingSealedGame.postValue(SealedClassGame.Error)
            }

        }
    }

    fun getScifiGamesVM() {
        viewModelScope.launch {
            _updatingSealedGame.postValue(SealedClassGame.Loading)

            try {
                val scifiGames = repositoryInt.getScifiGames()
                _updatingSealedGame.postValue(SealedClassGame.Content(scifiGames))
            }catch (e: Exception){
                _updatingSealedGame.postValue(SealedClassGame.Error)
            }

        }
    }

    //---------------------------------------------------
    //para mostrar en el fragment details:
    private val _itemGame = MutableLiveData<Game1>()
    val itemGame: LiveData<Game1>
        get() = _itemGame

    //para enviar desde fragmentRecyclerView a fragmentDetails:
    fun sendItemGame(game1: Game1) {
        _itemGame.value = game1
    }

    //--------------------------------------------------

    //ROOM:

    private val _getAllRoomGames = MutableLiveData<List<Games1Entity>>()
    val getAllRoomGames: LiveData<List<Games1Entity>>
        get() = _getAllRoomGames

    fun getAllGamesRoomVM() : LiveData<List<Games1Entity>> {
        viewModelScope.launch {
            _getAllRoomGames.value = repositoryInt.getAllFavoriteGamesRepo()
        }
        return _getAllRoomGames
    }

    fun insertGameVM(games1Entity: Games1Entity) {
        viewModelScope.launch {
            repositoryInt.insertFavoriteGamesRepo(games1Entity)
        }
    }
    fun deleteGame(games1Entity: Games1Entity) {
        viewModelScope.launch {
            repositoryInt.deleteFavoriteGamesRepo(games1Entity)
        }
    }


}