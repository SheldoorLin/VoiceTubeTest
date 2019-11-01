package com.sheldon.voicetubetest.ui.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sheldon.voicetubetest.data.SettingStatus
import com.sheldon.voicetubetest.data.source.VoiceTubeRepository
import com.sheldon.voicetubetest.util.Logger
import kotlinx.coroutines.*

class SettingViewModel(private val voiceTubeRepository: VoiceTubeRepository) : ViewModel() {

    val status: LiveData<SettingStatus> = voiceTubeRepository.getAllSetting()

    val isSwAutoPayOpen = MutableLiveData<Boolean>()

    val isSwLearnNotificationOpen = MutableLiveData<Boolean>()

    val isSwRecommendVideoNotificationOpen = MutableLiveData<Boolean>()

    val isSwStopPlayInCheckingOpen = MutableLiveData<Boolean>()

    val isSwSubtitleSync = MutableLiveData<Boolean>()

    val settingButtonStatus = MutableLiveData<SettingStatus>()

    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        Logger.i("------------------------------------")
        Logger.i("[${this::class.simpleName}]${this}")
        Logger.i("------------------------------------")

        isSwAutoPayOpen.value = status.value?.auto_play
        isSwLearnNotificationOpen.value = status.value?.learn_notification
        isSwRecommendVideoNotificationOpen.value = status.value?.recommend_video_notification
        isSwStopPlayInCheckingOpen.value = status.value?.stop_play_in_checking
        isSwSubtitleSync.value = status.value?.subtitle_sync

        Logger.d("status value = ${status.value}")

    }


    private fun updateDatabase(settingStatus: SettingStatus) {
        status.value?.let {
            coroutineScope.launch {
                voiceTubeRepository.updateSettingOnPage(settingStatus)
            }
        }
        Logger.d("I'm here")
    }

    fun changeStatus(settingStatus: SettingStatus) {

    }
}