package com.sheldon.voicetubetest.data.source

import androidx.lifecycle.LiveData
import com.sheldon.voicetubetest.data.HomeVideoData
import com.sheldon.voicetubetest.data.Result
import com.sheldon.voicetubetest.data.SettingStatus

interface VoiceTubeRepository {

    suspend fun getVoiceTubeServerData(): Result<HomeVideoData>

    fun getAllSetting(): LiveData<SettingStatus>

    suspend fun updateSettingOnPage(settingStatus: SettingStatus)

    suspend fun insertSettingOnPage(settingStatus: SettingStatus)
}