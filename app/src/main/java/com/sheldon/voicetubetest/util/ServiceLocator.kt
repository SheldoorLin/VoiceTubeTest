package com.sheldon.voicetubetest.util

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.sheldon.voicetubetest.data.source.DefaultVoiceTubeRepository
import com.sheldon.voicetubetest.data.source.VoiceTubeDataSource
import com.sheldon.voicetubetest.data.source.VoiceTubeRepository
import com.sheldon.voicetubetest.data.source.local.VoiceTubeLocalDataSource
import com.sheldon.voicetubetest.data.source.remote.VoiceTubeRemoteDataSource

object ServiceLocator {

    @Volatile
    var stylishRepository: VoiceTubeRepository? = null
        @VisibleForTesting set

    fun provideTasksRepository(context: Context): VoiceTubeRepository {
        synchronized(this) {
            return stylishRepository
                ?: stylishRepository
                ?: createStylishRepository(context)
        }
    }

    private fun createStylishRepository(context: Context): VoiceTubeRepository {
        return DefaultVoiceTubeRepository(
            VoiceTubeRemoteDataSource,
            createLocalDataSource(context)
        )
    }

    private fun createLocalDataSource(context: Context): VoiceTubeDataSource {
        return VoiceTubeLocalDataSource(context)
    }
}