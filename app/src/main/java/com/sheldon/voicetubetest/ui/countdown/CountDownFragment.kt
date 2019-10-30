package com.sheldon.voicetubetest.ui.countdown

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sheldon.voicetubetest.R

class CountDownFragment : Fragment() {

    private lateinit var countDownViewModel: CountDownViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        countDownViewModel =
            ViewModelProviders.of(this).get(CountDownViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_count_down, container, false)
        countDownViewModel.text.observe(this, Observer {
        })






        return root
    }
}