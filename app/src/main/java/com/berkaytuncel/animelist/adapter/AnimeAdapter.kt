package com.berkaytuncel.animelist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.berkaytuncel.animelist.R
import com.berkaytuncel.animelist.model.Anime
import kotlinx.android.synthetic.main.item_anime.view.*

class AnimeAdapter(val animeList: ArrayList<Anime>): RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    class AnimeViewHolder(var view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.view.name.text = animeList[position].animeName
        holder.view.episodes.text = animeList[position].animeEpisodes
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    fun updateAnimeList(newAnimeList: List<Anime>){
        animeList.clear()
        animeList.addAll(newAnimeList)
        notifyDataSetChanged()
    }
}