package com.rewqty.prototypelistanime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rewqty.prototypelistanime.databinding.AnimeItemBinding
import com.rewqty.prototypelistanime.model.Anime
import com.squareup.picasso.Picasso

class AnimeAdapter() : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    var data: List<Anime> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AnimeItemBinding.inflate(inflater, parent, false)

        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = data[position]

        with(holder.binding) {
            titleAnime.text = anime.title
            Picasso.get().load(anime.poster).into(posterAnime)
        }
    }

    override fun getItemCount(): Int = data.size

    class AnimeViewHolder(val binding: AnimeItemBinding) : RecyclerView.ViewHolder(binding.root)
}