package com.sheldon.voicetubetest

import android.app.Application
import com.sheldon.voicetubetest.data.source.VoiceTubeRepository
import com.sheldon.voicetubetest.util.ServiceLocator
import kotlin.properties.Delegates

class VoiceTubeApplication :Application(){

    // Depends on the flavor,
    val voiceTubeRepository: VoiceTubeRepository
        get() = ServiceLocator.provideTasksRepository(this)

    companion object {
        var instance: VoiceTubeApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}