package com.training.islamiapp.ui.screens.home.frags.ahadeth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.training.islamiapp.databinding.FragmentAhadeethBinding

class AhadethFragment : Fragment() {

    private lateinit var binding: FragmentAhadeethBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAhadeethBinding.inflate(inflater, container, false)








        return binding.root
    }

}