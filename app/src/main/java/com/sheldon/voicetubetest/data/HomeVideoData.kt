package com.sheldon.voicetubetest.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomeVideoData(

    val status: String,

    val videos: List<Videos>
) : Parcelable


@Parcelize
data class Videos(

    val title: String,

    val img: String
) : Parcelable