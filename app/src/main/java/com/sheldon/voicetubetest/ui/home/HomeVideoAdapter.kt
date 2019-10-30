package com.sheldon.voicetubetest.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sheldon.voicetubetest.data.Videos
import com.sheldon.voicetubetest.databinding.ItemHomeRecycelerBinding

class HomeVideoAdapter : ListAdapter<Videos, HomeVideoAdapter.ItemViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Videos>() {
        override fun areItemsTheSame(oldItem: Videos, newItem: Videos): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Videos, newItem: Videos): Boolean {
            return (oldItem.title == newItem.title && oldItem.img == newItem.img)
        }
    }

    class ItemViewHolder(var binding: ItemHomeRecycelerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(videos: Videos) {
            binding.videos= videos
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    ItemHomeRecycelerBinding.inflate(layoutInflater, parent, false)
                return ItemViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val videos = getItem(position)
        holder.bind(videos)
    }
}