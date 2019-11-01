package com.sheldon.voicetubetest.data.source

import androidx.lifecycle.LiveData
import com.sheldon.voicetubetest.data.HomeVideoData
import com.sheldon.voicetubetest.data.Result
import com.sheldon.voicetubetest.data.SettingStatus
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DefaultVoiceTubeRepository(
    private val voiceTubeRemoteDataSource: VoiceTubeDataSource,
    private val voiceTubeLocalDataSource: VoiceTubeDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : VoiceTubeRepository {
    override suspend fun getVoiceTubeServerData(): Result<HomeVideoData> {
        return voiceTubeRemoteDataSource.getVoiceTubeServerData()
    }
    override fun getAllSetting(): LiveData<SettingStatus>{
        return voiceTubeLocalDataSource.getAllSetting()
    }

    override suspend fun insertSettingOnPage(settingStatus: SettingStatus){
        voiceTubeLocalDataSource.insertSettingOnPage(settingStatus)
    }

    override suspend fun updateSettingOnPage(settingStatus: SettingStatus) {
        voiceTubeLocalDataSource.updateSettingOnPage(settingStatus)
    }
}