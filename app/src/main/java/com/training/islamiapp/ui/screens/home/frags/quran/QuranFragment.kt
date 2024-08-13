package com.training.islamiapp.ui.screens.home.frags.quran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.training.islamiapp.databinding.FragmentQuranBinding
import com.training.islamiapp.ui.utils.Constants

class QuranFragment : Fragment() {

    private lateinit var binding: FragmentQuranBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentQuranBinding.inflate(inflater, container, false)


        binding.rvChapters.adapter = ChaptersAdapter(Constants.chapters)



        return binding.root
    }

}