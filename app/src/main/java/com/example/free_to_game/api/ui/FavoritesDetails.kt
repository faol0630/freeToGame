package com.example.free_to_game.api.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.example.free_to_game.R
import com.example.free_to_game.api.data.model.Game1
import com.example.free_to_game.api.data.model.Games1Entity
import com.example.free_to_game.api.presentation.ViewModelGame
import com.example.free_to_game.databinding.FavoritesDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesDetails : Fragment(R.layout.favorites_details) {

    private lateinit var binding: FavoritesDetailsBinding

    private val viewModel: ViewModelGame by activityViewModels()

    private lateinit var game: Game1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FavoritesDetailsBinding.bind(view)

        viewModel.itemGame.observe(requireActivity()) {
            binding.textViewIdFavoritesDetails.text = it.id
            binding.textViewPlatformFavoritesDetails.text = it.platform
            binding.textViewDeveloperFavoritesDetails.text = it.developer
            binding.textViewPublisherFavoritesDetails.text = it.publisher
            binding.textViewReleaseDateFavoritesDetails.text = it.release_date
            binding.textViewTitleFavoritesDetails.text = it.title
            binding.textViewUrlFavoritesDetails.text = it.game_url
            binding.tvShortDescription.text = it.short_description
            Glide.with(binding.imageViewGameFD)
                .asBitmap()
                .load(it.thumbnail)
                .into(BitmapImageViewTarget(binding.imageViewGameFD))

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

        binding.btnDeleteGameFD.setOnClickListener {

            viewModel.deleteGame(
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
            Toast.makeText(requireContext(), "Game deleted from favorites", Toast.LENGTH_SHORT)
                .show()
        }
        //Web site game:
        binding.textViewUrlFavoritesDetails.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(binding.textViewUrlFavoritesDetails.text.toString()))
            startActivity(intent)
        }


    }
}