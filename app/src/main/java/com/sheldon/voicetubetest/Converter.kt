package com.sheldon.voicetubetest

import androidx.databinding.InverseMethod

object Converter {
    @InverseMethod("longToString")
    fun stringToLong(string: String): Long {
        return try {
            string.toLong()
        } catch (e: Exception) {
            0L
        }
    }

    fun longToString(long: Long): String {
        return long.toString()
    }

}