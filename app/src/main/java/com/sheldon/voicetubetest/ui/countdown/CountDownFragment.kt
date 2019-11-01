package com.sheldon.voicetubetest.ui.countdown

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.sheldon.voicetubetest.Converter
import com.sheldon.voicetubetest.databinding.FragmentCountDownBinding
import com.sheldon.voicetubetest.ext.getVmFactory

class CountDownFragment : Fragment() {


    private val countDownViewModel by viewModels<CountDownViewModel> { getVmFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCountDownBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        binding.converter = Converter

        binding.viewModel = countDownViewModel

        binding.btnStart.setOnClickListener {
            countDownViewModel.startCountDown()
        }

        binding.btnPause.setOnClickListener {

            countDownViewModel.pauseCountDown()
        }

        binding.btnResume.setOnClickListener {
            countDownViewModel.resumeCountDown()
        }


        countDownViewModel.countShowTime.observe(this, Observer {
            it?.let {
              binding.txShowTime.text = Converter.longToString(it)
            }
        })

        countDownViewModel.isOnCounting.observe(this, Observer {
            if (it == false){
                val text = "Count Finish"
                binding.txShowTime.text = text
            }
        })
        return binding.root
    }
}