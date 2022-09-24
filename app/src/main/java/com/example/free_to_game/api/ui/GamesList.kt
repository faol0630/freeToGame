package com.example.free_to_game.api.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.free_to_game.R
import com.example.free_to_game.api.core.SealedClassGame
import com.example.free_to_game.api.data.model.Game1
import com.example.free_to_game.api.presentation.ViewModelGame
import com.example.free_to_game.databinding.GamesListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamesList : Fragment(R.layout.games_list), AdapterGame.OnGameClickListener {

    private val adapterGame = AdapterGame(this)

    private lateinit var binding: GamesListBinding

    private val viewModel : ViewModelGame by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = GamesListBinding.bind(view)

        binding.RecyclerView1.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.RecyclerView1.adapter = adapterGame

        viewModel.updatinSealedGame.observe(requireActivity()){
            uploadingSealedClass(it)
        }


    }

    private fun uploadingSealedClass(sealedClassGame: SealedClassGame) {
        when(sealedClassGame){
            SealedClassGame.Loading -> {
                binding.RecyclerView1.visibility = View.GONE
                binding.imageView1.visibility = View.GONE
                binding.ProgressBar1.visibility = View.VISIBLE
            }
            SealedClassGame.Error -> {
                binding.RecyclerView1.visibility = View.GONE
                binding.imageView1.visibility = View.VISIBLE
                binding.ProgressBar1.visibility = View.GONE
            }
            is SealedClassGame.Content -> {
                binding.RecyclerView1.visibility = View.VISIBLE
                binding.imageView1.visibility = View.GONE
                binding.ProgressBar1.visibility = View.GONE
                adapterGame.getGamesData(sealedClassGame.gamesList)
            }

        }
    }

    override fun onGameClick(game1: Game1, position: Int) {
        viewModel.sendItemGame(game1)
        findNavController().navigate(R.id.action_gamesList_to_gamesDetails)
    }
}