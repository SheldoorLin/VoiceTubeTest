package com.sheldon.voicetubetest.data.source.local

import android.content.Context
import androidx.lifecycle.LiveData
import com.sheldon.voicetubetest.data.HomeVideoData
import com.sheldon.voicetubetest.data.Result
import com.sheldon.voicetubetest.data.SettingStatus
import com.sheldon.voicetubetest.data.source.VoiceTubeDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VoiceTubeLocalDataSource(val context: Context) : VoiceTubeDataSource {

    override suspend fun getVoiceTubeServerData(): Result<HomeVideoData> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllSetting(): LiveData<SettingStatus> {
        return VoiceTubeDatabase.getInstance(context).voiceTubeDatabaseDao.getAllSetting()
    }

    override suspend fun insertSettingOnPage(settingStatus: SettingStatus){
        withContext(Dispatchers.IO){
            VoiceTubeDatabase.getInstance(context).voiceTubeDatabaseDao.insert(settingStatus)
        }
    }

    override suspend fun updateSettingOnPage(settingStatus: SettingStatus) {
        withContext(Dispatchers.IO) {
            VoiceTubeDatabase.getInstance(context).voiceTubeDatabaseDao.update(settingStatus)
        }
    }
}