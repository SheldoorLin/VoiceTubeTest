package com.sheldon.voicetubetest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sheldon.voicetubetest.R
import com.sheldon.voicetubetest.data.HomeVideoData
import com.sheldon.voicetubetest.data.Result
import com.sheldon.voicetubetest.data.source.VoiceTubeRepository
import com.sheldon.voicetubetest.network.LoadApiStatus
import com.sheldon.voicetubetest.util.Logger
import com.sheldon.voicetubetest.util.Util.getString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel(private val voiceTubeRepository: VoiceTubeRepository) : ViewModel() {

    private val _homeVideoData = MutableLiveData<HomeVideoData>()
    val homeVideoData: LiveData<HomeVideoData>
        get() = _homeVideoData

    // status: The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<LoadApiStatus>()
    val status: LiveData<LoadApiStatus>
        get() = _status

    // error: The internal MutableLiveData that stores the error of the most recent request
    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    // status for the loading icon of swl
    private val _refreshStatus = MutableLiveData<Boolean>()
    val refreshStatus: LiveData<Boolean>
        get() = _refreshStatus

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        Logger.i("------------------------------------")
        Logger.i("[${this::class.simpleName}]${this}")
        Logger.i("------------------------------------")
        getVoiceTubeServerData(true)
    }

    private fun getVoiceTubeServerData(isInitial: Boolean = false) {
        coroutineScope.launch {
            if (isInitial) _status.value = LoadApiStatus.LOADING

            val result = voiceTubeRepository.getVoiceTubeServerData()

            _homeVideoData.value = when(result){
                is Result.Success -> {
                    _error.value = null
                    if (isInitial)_status.value = LoadApiStatus.DONE
                    result.data
                }
                is Result.Fail -> {
                    _error.value = result.error
                    if (isInitial) _status.value =LoadApiStatus.ERROR
                    null
                }
                is Result.Error-> {
                    _error.value = result.exception.toString()
                    if (isInitial)_status.value = LoadApiStatus.ERROR
                    null
                }
                else -> {
                    _error.value = getString(R.string.you_know_nothing)
                    if (isInitial)_status.value = LoadApiStatus.ERROR
                    null
                }
            }
           _refreshStatus.value = false
        }
    }
}