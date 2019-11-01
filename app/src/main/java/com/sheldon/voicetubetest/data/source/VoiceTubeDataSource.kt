package com.sheldon.voicetubetest.data.source

import androidx.lifecycle.LiveData
import com.sheldon.voicetubetest.data.*
import com.sheldon.voicetubetest.data.Videos

interface VoiceTubeDataSource {

    suspend fun getVoiceTubeServerData(): Result<HomeVideoData>

    fun getAllSetting():LiveData<SettingStatus>

    suspend fun insertSettingOnPage(settingStatus: SettingStatus)

    suspend fun updateSettingOnPage(settingStatus: SettingStatus)

}