package com.sheldon.voicetubetest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sheldon.voicetubetest.databinding.FragmentHomeBinding
import com.sheldon.voicetubetest.ext.getVmFactory

class HomeFragment : Fragment() {

    private val homeViewModel by viewModels<HomeViewModel> { getVmFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this


        binding.viewModel = homeViewModel

        binding.homeRecyclerView.adapter = HomeVideoAdapter()

        homeViewModel.homeVideoData.value?.let { videoData ->
            binding.homeRecyclerView.scrollToPosition(videoData.videos.size)
        }

        return binding.root
    }
}