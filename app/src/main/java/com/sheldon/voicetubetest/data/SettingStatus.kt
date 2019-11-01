package com.sheldon.voicetubetest.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Entity(
    tableName = "status_in_setting_table",
    primaryKeys = ["auto_play", "learn_notification", "recommend_video_notification", "stop_play_in_checking", "subtitle_sync"]
)
@Parcelize
data class SettingStatus(
    @ColumnInfo(name = "auto_play") var auto_play: Boolean = true,

    @ColumnInfo(name = "learn_notification") var learn_notification: Boolean = true,

    @ColumnInfo(name = "recommend_video_notification") var recommend_video_notification: Boolean = true,

    @ColumnInfo(name = "stop_play_in_checking") var stop_play_in_checking: Boolean = true,

    @ColumnInfo(name = "subtitle_sync") var subtitle_sync: Boolean = true
) : Parcelable