package com.pvasilev.music.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.util.Util
import com.pvasilev.music.R
import com.pvasilev.music.data.models.Song
import kotlinx.android.synthetic.main.item_song.view.*
import java.util.*

class SongsAdapter : ListAdapter<Song, SongsAdapter.SongVH>(this) {
    companion object : DiffUtil.ItemCallback<Song>() {
        override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongVH {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return SongVH(itemView)
    }

    override fun onBindViewHolder(holder: SongVH, position: Int) {
        holder.bind(getItem(position))
    }

    class SongVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val formatBuilder: StringBuilder = StringBuilder()

        private val formatter: Formatter = Formatter(formatBuilder, Locale.getDefault())

        fun bind(song: Song) {
            itemView.tv_track_number.text = (adapterPosition + 1).toString()
            itemView.tv_title.text = song.name
            itemView.tv_duration.text = Util.getStringForTime(formatBuilder, formatter, song.duration)
        }
    }
}