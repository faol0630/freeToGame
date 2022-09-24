package com.example.free_to_game.api.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.free_to_game.R
import com.example.free_to_game.api.data.model.Game1
import com.example.free_to_game.api.presentation.ViewModelGame
import com.example.free_to_game.databinding.FavoritesListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesList : Fragment(R.layout.favorites_list), AdapterGame.OnGameClickListener {

    private lateinit var binding: FavoritesListBinding

    private val adapterGame = AdapterGame(this)

    private val viewModel: ViewModelGame by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FavoritesListBinding.bind(view)

        binding.RecyclerView1Favorites.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        favoritesObserver()

        viewModel.getAllGamesRoomVM()

    }

    private fun favoritesObserver() {
        viewModel.getAllRoomGames.observe(requireActivity()){
            binding.RecyclerView1Favorites.adapter = adapterGame

            val list: List<Game1> = it.map {
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
            adapterGame.getGamesData(list)
        }
    }

    //Going to FragmentFavoritesDetails:
    override fun onGameClick(game1: Game1, position: Int) {
        viewModel.sendItemGame(game1)
        findNavController().navigate(R.id.action_favoritesList_to_favoritesDetails)
    }
}