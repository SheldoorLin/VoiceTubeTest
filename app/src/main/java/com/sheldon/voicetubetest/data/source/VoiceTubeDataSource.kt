package com.sheldon.voicetubetest.data.source

import com.sheldon.voicetubetest.data.*
import com.sheldon.voicetubetest.data.Videos

interface VoiceTubeDataSource {

    suspend fun getVoiceTubeServerData(): Result<HomeVideoData>

}