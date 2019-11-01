package com.sheldon.voicetubetest.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sheldon.voicetubetest.data.source.VoiceTubeRepository
import com.sheldon.voicetubetest.ui.home.HomeViewModel
import com.sheldon.voicetubetest.ui.setting.SettingViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val voiceTubeRepository: VoiceTubeRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(HomeViewModel::class.java) ->
                    HomeViewModel(voiceTubeRepository)

                isAssignableFrom(SettingViewModel::class.java) ->
                    SettingViewModel(voiceTubeRepository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}