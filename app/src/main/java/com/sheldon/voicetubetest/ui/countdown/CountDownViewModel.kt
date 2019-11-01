package com.sheldon.voicetubetest.ui.countdown


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sheldon.voicetubetest.data.source.VoiceTubeRepository
import com.sheldon.voicetubetest.util.Logger

class CountDownViewModel(private val voiceTubeRepository: VoiceTubeRepository) : ViewModel() {


    var countShowTime = MutableLiveData<Long>()

    var countDownTime: Long = 10L

    val isOnCounting = MutableLiveData<Boolean>()

    init {
        countShowTime.value = 0L
    }

    private val counter = object : CountDownTimer(countDownTime* 1000, 1000) {
        override fun onFinish() {
            isOnCounting.value = false
        }

        override fun onTick(millisUntilFinished: Long) {
            countShowTime.value = millisUntilFinished / 1000
            Logger.d("time is ${millisUntilFinished / 1000}")
        }
    }


    fun startCountDown() {
        counter.resume()
    }

    fun pauseCountDown() {
        counter.pause()
    }

    fun resumeCountDown() {
        counter.start()
    }
}