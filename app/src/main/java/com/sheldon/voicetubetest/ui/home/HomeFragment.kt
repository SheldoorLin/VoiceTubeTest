package com.sheldon.voicetubetest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sheldon.voicetubetest.R
import com.sheldon.voicetubetest.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this


        binding.homeRecyclerView.layoutManager = LinearLayoutManager(this.context)

        binding.homeRecyclerView.adapter = HomeVideoAdapter()

        homeViewModel.homeVideoData.observe(this, Observer {
            it.let {
                (binding.homeRecyclerView.adapter as HomeVideoAdapter).submitList(it.videos)
            }
        })

        return binding.root
    }
}