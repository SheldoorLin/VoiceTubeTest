package com.sheldon.voicetubetest.data.source.local

import android.content.Context
import com.sheldon.voicetubetest.data.*
import com.sheldon.voicetubetest.data.source.VoiceTubeDataSource

class VoiceTubeLocalDataSource(val context: Context) : VoiceTubeDataSource {

    override suspend fun getVoiceTubeServerData(): Result<HomeVideoData> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}