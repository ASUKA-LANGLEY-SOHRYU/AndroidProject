package com.example.androidproject.presenter.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.signature.ObjectKey
import com.example.androidproject.R
import com.example.androidproject.databinding.ListItemBinding
import com.example.androidproject.presenter.model.AnimeListItem

class AnimeListAdapter : RecyclerView.Adapter<AnimeListAdapter.AnimeListViewHolder>() {

    private var animes: MutableList<AnimeListItem> = mutableListOf()
    private lateinit var onButtonClickListener: OnButtonClickListener
    private lateinit var onScrolledToTheEndListener: OnScrolledToTheEndListener

    @SuppressLint("NotifyDataSetChanged")
    fun addAnime(value: AnimeListItem){
        animes.add(value)
        notifyItemChanged(animes.size - 1)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setAnime(value: MutableList<AnimeListItem>){
        this.animes = value
        notifyItemChanged(0)
        notifyDataSetChanged()
    }

    interface OnButtonClickListener {
        fun onButtonClick(position: Int)
    }

    fun setOnButtonClickListener(listener: OnButtonClickListener){
        onButtonClickListener = listener
    }

    interface OnScrolledToTheEndListener {
        fun onScrolledToTheEnd();
    }

    fun setOnScrolledToTheEndListener(listener: OnScrolledToTheEndListener) {
        onScrolledToTheEndListener = listener
    }

    inner class AnimeListViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ListItemBinding.bind(view)


        fun bind(anime: AnimeListItem){
            binding.apply {
                title.text = anime.title
                description.text = anime.description

                Glide.with(itemView.context)
                    .load(anime.smallImageUrl)
                    .signature(ObjectKey(anime.smallImageUrl.hashCode().toString()))
                    .transform(RoundedCorners(10))
                    .error(R.drawable.ic_launcher_foreground)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(image)

                open.setOnClickListener {
                    onButtonClickListener.onButtonClick(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return AnimeListViewHolder(view)
    }

    override fun getItemCount(): Int = animes.size

    override fun onBindViewHolder(holder: AnimeListViewHolder, position: Int) {
        holder.bind(animes[position])
        if (::onScrolledToTheEndListener.isInitialized && position == itemCount - 1)
            onScrolledToTheEndListener.onScrolledToTheEnd()
    }
}