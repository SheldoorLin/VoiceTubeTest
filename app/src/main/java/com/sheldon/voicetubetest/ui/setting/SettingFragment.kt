package com.sheldon.voicetubetest.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sheldon.voicetubetest.R
import com.sheldon.voicetubetest.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

    private lateinit var settingViewModel: SettingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingViewModel =
            ViewModelProviders.of(this).get(SettingViewModel::class.java)
        val binding = FragmentSettingBinding.inflate(inflater, container, false)


        return binding.root
    }
}