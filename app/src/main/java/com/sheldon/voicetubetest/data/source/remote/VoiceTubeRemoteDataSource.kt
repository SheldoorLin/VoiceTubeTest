package com.sheldon.voicetubetest.data.source.remote

import com.sheldon.voicetubetest.R
import com.sheldon.voicetubetest.data.*
import com.sheldon.voicetubetest.data.Videos
import com.sheldon.voicetubetest.data.source.VoiceTubeDataSource
import com.sheldon.voicetubetest.network.VoiceTubeApi
import com.sheldon.voicetubetest.util.Logger
import com.sheldon.voicetubetest.util.Util.getString
import com.sheldon.voicetubetest.util.Util.isInternetConnected


object VoiceTubeRemoteDataSource : VoiceTubeDataSource {

    override suspend fun getVoiceTubeServerData(): Result<HomeVideoData> {

        if (!isInternetConnected()) {
            return Result.Fail(getString(R.string.internet_not_connected))
        }
        // Get the Deferred object for our Retrofit request
        val getResultDeferred = VoiceTubeApi.retrofitService.getVoiceTubeData()
        return try {
            // this will run on a thread managed by Retrofit
            val listResult = getResultDeferred.await()

            Result.Success(listResult)

        } catch (e: Exception) {
            Logger.w("[${this::class.simpleName}] exception=${e.message}")
            Result.Error(e)
        }
    }
}
