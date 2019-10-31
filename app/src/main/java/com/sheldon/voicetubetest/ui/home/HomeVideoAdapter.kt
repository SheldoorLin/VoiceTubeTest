package com.sheldon.voicetubetest.ui.home

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sheldon.voicetubetest.R
import com.sheldon.voicetubetest.data.Videos
import com.sheldon.voicetubetest.databinding.ItemHomeRecycelerBinding

class HomeVideoAdapter : RecyclerView.Adapter<HomeVideoAdapter.ItemViewHolder>() {

    private lateinit var context: Context

    private var videos: List<Videos>? = null

    class ItemViewHolder(private var binding: ItemHomeRecycelerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, videos: Videos) {

            videos.let {
                binding.videos = it
                val displayMetrics = DisplayMetrics()
                (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
                binding.imgVideo.layoutParams = ConstraintLayout.LayoutParams(
                    displayMetrics.widthPixels, context.resources.getDimensionPixelSize(
                        R.dimen.height_detail_gallery
                    )
                )
                binding.executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        context = parent.context
        return ItemViewHolder(
            ItemHomeRecycelerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        videos?.let {
            holder.bind(context, it[getRealPosition(position)])
        }
    }

    override fun getItemCount(): Int {
        return videos?.let { Int.MAX_VALUE } ?: 0
    }

    private fun getRealPosition(position: Int): Int = videos?.let {
        position % it.size
    } ?: 0

    fun submitVideos(videos: List<Videos>) {
        this.videos = videos
        notifyDataSetChanged()
    }
}