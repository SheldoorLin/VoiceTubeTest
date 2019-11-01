package com.sheldon.voicetubetest.ui.setting

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.sheldon.voicetubetest.data.SettingStatus
import com.sheldon.voicetubetest.databinding.FragmentSettingBinding
import com.sheldon.voicetubetest.ext.getVmFactory
import com.sheldon.voicetubetest.util.Logger

class SettingFragment : Fragment() {

    private val settingViewModel by viewModels<SettingViewModel> { getVmFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSettingBinding.inflate(inflater, container, false)

        binding.viewModel = settingViewModel

        binding.lifecycleOwner = this


        settingViewModel.isSwAutoPayOpen.observe(this, Observer {
            it.let {
//                settingViewModel.settingButtonStatus.value?.auto_play = it
                Logger.d("settingButtonStatus is ${settingViewModel.settingButtonStatus.value}")
                Logger.d("value is $it")
            }
        })


        return binding.root
    }
}