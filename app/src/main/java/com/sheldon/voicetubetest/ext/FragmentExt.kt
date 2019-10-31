package com.sheldon.voicetubetest.ext

import androidx.fragment.app.Fragment
import com.sheldon.voicetubetest.VoiceTubeApplication
import com.sheldon.voicetubetest.factory.ViewModelFactory

fun Fragment.getVmFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as VoiceTubeApplication).voiceTubeRepository
    return ViewModelFactory(repository)
}