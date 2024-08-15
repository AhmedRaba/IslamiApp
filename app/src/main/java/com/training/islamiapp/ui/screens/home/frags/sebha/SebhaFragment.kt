package com.training.islamiapp.ui.screens.home.frags.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.training.islamiapp.R
import com.training.islamiapp.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {

    private lateinit var binding: FragmentSebhaBinding

    private lateinit var azkarlist: MutableList<String>

    var counter = 0
    var currentindex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSebhaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarlist = resources.getStringArray(R.array.azkarList).toMutableList()

        binding.tvDhikr.text = azkarlist[currentindex]
        binding.tvDhikrCounter.text = counter.toString()

        onSebhaClick()
    }


    private fun onSebhaClick() {

        binding.ivSebhaBody.setOnClickListener {
            binding.ivSebhaBody.rotation += (360 / 33).toFloat()
            if (counter < 33) {
                counter++
            } else {
                counter = 0
                currentindex = if (currentindex < azkarlist.size - 1) ++currentindex else 0
                binding.tvDhikr.text = azkarlist[currentindex]
            }
            binding.tvDhikrCounter.text = counter.toString()
        }
    }

}