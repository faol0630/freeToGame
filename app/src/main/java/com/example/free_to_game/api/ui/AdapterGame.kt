package com.example.free_to_game.api.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.free_to_game.api.data.model.Game1
import com.example.free_to_game.databinding.ItemGameBinding

class AdapterGame(
    private val itemClickListener: OnGameClickListener
) : RecyclerView.Adapter<AdapterGame.ViewHolder>() {

    interface OnGameClickListener {
        fun onGameClick(game1: Game1, position: Int)
    }

    private var gamesList: List<Game1> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ViewHolder(itemBinding.itemGame1)
        itemBinding.root.setOnClickListener {
            val position = holder.adapterPosition.takeIf {
                it != RecyclerView.NO_POSITION
            } ?: return@setOnClickListener
            itemClickListener.onGameClick(gamesList[position], position)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.insideViewHolder(gamesList[position])
    }

    override fun getItemCount(): Int = gamesList.size

    fun getGamesData(games: List<Game1>) {
        this.gamesList = games
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun insideViewHolder(game1: Game1) {
            val itemGame = ItemGameBinding.bind(itemView)
            itemGame.apply {
                itemGame.textViewPlatform.text = game1.platform
                itemGame.textViewReleaseDate.text = game1.release_date
                itemGame.textViewTitle.text = game1.title

                Glide.with(imageViewGame)
                    .load(game1.thumbnail)
                    .into(imageViewGame)

            }
        }
    }
}