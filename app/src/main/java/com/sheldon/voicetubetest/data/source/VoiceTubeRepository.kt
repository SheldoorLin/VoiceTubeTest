package com.sheldon.voicetubetest.data.source

import com.sheldon.voicetubetest.data.HomeVideoData
import com.sheldon.voicetubetest.data.Result

interface VoiceTubeRepository {
    suspend fun getVoiceTubeServerData(): Result<HomeVideoData>
}