package com.sheldon.voicetubetest.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "status_in_setting_table")

data class SettingStatus(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "auto_play") var auto_play: Boolean ,

    @ColumnInfo(name = "learn_notification") var learn_notification: Boolean,

    @ColumnInfo(name = "recommend_video_notification") var recommend_video_notification: Boolean ,

    @ColumnInfo(name = "stop_play_in_checking") var stop_play_in_checking: Boolean,

    @ColumnInfo(name = "subtitle_sync") var subtitle_sync: Boolean
)