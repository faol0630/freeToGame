package com.example.free_to_game.api.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.free_to_game.R
import com.example.free_to_game.api.data.model.Game1
import com.example.free_to_game.api.data.model.Games1Entity
import com.example.free_to_game.api.presentation.ViewModelGame
import com.example.free_to_game.databinding.GamesDetailsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GamesDetails : Fragment(R.layout.games_details) {

    private lateinit var binding: GamesDetailsBinding

    private lateinit var game: Game1

    private val viewModel: ViewModelGame by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = GamesDetailsBinding.bind(view)

        viewModel.itemGame.observe(requireActivity()) {
            binding.textViewIdDetails.text = it.id
            binding.textViewDeveloperDetails.text = it.developer
            binding.textViewTitleDetails.text = it.title
            binding.textViewUrlDetails.text = it.game_url
            binding.textViewPlatformDetails.text = it.platform
            binding.textViewPublisherDetails.text = it.publisher
            binding.textViewReleaseDateDetails.text = it.release_date
            binding.tvShortDescription.text = it.short_description
            Glide.with(requireContext())
                .load(it.thumbnail)
                .into(binding.imageViewGameFD)

            game = Game1(
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

        binding.btnSaveGame.setOnClickListener {

            viewModel.insertGameVM(
                Games1Entity(
                    game.id,
                    game.title,
                    game.game_url,
                    game.platform,
                    game.publisher,
                    game.developer,
                    game.release_date,
                    game.thumbnail,
                    game.short_description
                )
            )

            Toast.makeText(context, "Game saved to Favorites", Toast.LENGTH_LONG).show()
        }
        //Web site game:
        binding.textViewUrlDetails.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(binding.textViewUrlDetails.text.toString()))
            startActivity(intent)
        }
    }


}