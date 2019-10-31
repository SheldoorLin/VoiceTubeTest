package com.sheldon.voicetubetest.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.sheldon.voicetubetest.VoiceTubeApplication

object Util {

    fun isInternetConnected(): Boolean {
        val cm = VoiceTubeApplication.instance
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }

    fun getString(resourceId: Int): String {
        return VoiceTubeApplication.instance.getString(resourceId)
    }

    fun getColor(resourceId: Int): Int {
        return VoiceTubeApplication.instance.getColor(resourceId)
    }
}
