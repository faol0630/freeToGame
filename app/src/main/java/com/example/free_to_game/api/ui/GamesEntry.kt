package com.example.free_to_game.api.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.free_to_game.R
import com.example.free_to_game.api.presentation.ViewModelGame
import com.example.free_to_game.databinding.EntryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamesEntry : Fragment(R.layout.entry) {

    private lateinit var binding : EntryBinding

    private val viewModel : ViewModelGame by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = EntryBinding.bind(view)

        binding.btnAllGames.setOnClickListener {
            viewModel.getAllGamesVM()
            findNavController().navigate(R.id.action_gamesEntry_to_gamesList)
        }
        binding.btnBrowserGames.setOnClickListener {
            viewModel.getBrowserGamesVM()
            findNavController().navigate(R.id.action_gamesEntry_to_gamesList)
        }
        binding.btnPCGames.setOnClickListener {
            viewModel.getPCGamesVM()
            findNavController().navigate(R.id.action_gamesEntry_to_gamesList)
        }
        binding.btnShooter.setOnClickListener {
            viewModel.getShooterGamesVM()
            findNavController().navigate(R.id.action_gamesEntry_to_gamesList)
        }
        binding.btnRacing.setOnClickListener {
            viewModel.getRacingGamesVM()
            findNavController().navigate(R.id.action_gamesEntry_to_gamesList)
        }
        binding.btnSuperhero.setOnClickListener {
            viewModel.getSuperheroGamesVM()
            findNavController().navigate(R.id.action_gamesEntry_to_gamesList)
        }
        binding.btnByReleaseDate.setOnClickListener {
            viewModel.getGamesByReleaseDateVM()
            findNavController().navigate(R.id.action_gamesEntry_to_gamesList)
        }
        binding.btnAlphabetically.setOnClickListener {
            viewModel.getGamesAlphabeticallyVM()
            findNavController().navigate(R.id.action_gamesEntry_to_gamesList)
        }
        binding.btnFlight.setOnClickListener {
            viewModel.getFlightGamesVM()
            findNavController().navigate(R.id.action_gamesEntry_to_gamesList)
        }
        binding.btnAnime.setOnClickListener {
            viewModel.getAnimeGamesVM()
            findNavController().navigate(R.id.action_gamesEntry_to_gamesList)
        }
        binding.btnScifi.setOnClickListener {
            viewModel.getScifiGamesVM()
            findNavController().navigate(R.id.action_gamesEntry_to_gamesList)
        }
        binding.btnFavorites.setOnClickListener {
            findNavController().navigate(R.id.action_gamesEntry_to_favoritesList)
        }
    }
}