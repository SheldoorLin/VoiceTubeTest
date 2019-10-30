package com.sheldon.voicetubetest

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sheldon.voicetubetest.data.Videos
import com.sheldon.voicetubetest.ui.home.HomeVideoAdapter


@BindingAdapter("videoItems")
fun bindRecyclerViewWithVideoItems(recyclerView: RecyclerView, videoItems: List<Videos>?) {
    videoItems?.let {
        recyclerView.adapter?.apply {
            when (this) {
                is HomeVideoAdapter -> submitList(it)
            }
        }
    }
}


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUrl = it.toUri().buildUpon().build()
        Glide.with(imgView.context)
            .load(imgUrl)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .override(350, 200)
            .into(imgView)
    }
}