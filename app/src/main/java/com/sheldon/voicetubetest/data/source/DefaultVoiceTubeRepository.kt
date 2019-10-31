package com.sheldon.voicetubetest.data.source

import com.sheldon.voicetubetest.data.HomeVideoData
import com.sheldon.voicetubetest.data.Result
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
}