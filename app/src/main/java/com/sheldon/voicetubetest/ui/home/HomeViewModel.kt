package com.sheldon.voicetubetest.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sheldon.voicetubetest.data.HomeVideoData
import com.sheldon.voicetubetest.network.VoiceTubeApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


    private val _homeVideoData = MutableLiveData<HomeVideoData>()
    val homeVideoData : LiveData<HomeVideoData>
    get() = _homeVideoData


    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getProperties()
    }

    private fun getProperties() {
        coroutineScope.launch {
            val getPropertiesDeferred = VoiceTubeApi.retrofitService.getVoiceTubeData()
            try {
                // this will run on a thread managed by Retrofit
                val listResult = getPropertiesDeferred.await()

                _homeVideoData.value = listResult
                Log.d("hihi","data from Api ==== $listResult")

            } catch (e: Exception) {
                Log.i("Demo", "exception=${e.message}")
            }
        }
    }
}