package com.berkaytuncel.animelist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.berkaytuncel.animelist.R
import com.berkaytuncel.animelist.model.response.AnimeDataResponse
import com.berkaytuncel.animelist.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_anime.view.*

class AnimeAdapter(var animeList: ArrayList<AnimeDataResponse.Datum>): RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    class AnimeViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.view.name.text = animeList[position].title
        holder.view.episodes.text = animeList[position].episodes.toString()

        holder.view.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToAnimeFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    fun updateAnimeList(newAnimeList: List<AnimeDataResponse.Datum>){
        animeList.clear()
        animeList.addAll(newAnimeList)
        notifyDataSetChanged()
    }
}