package com.training.islamiapp.ui.screens.home.frags.ahadeth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.training.islamiapp.databinding.FragmentAhadeethBinding
import com.training.islamiapp.ui.model.Hadeth
import com.training.islamiapp.ui.screens.hadeth_details.HadethDetailsActivity
import java.io.BufferedReader
import java.io.InputStreamReader

class AhadethFragment : Fragment() {

    private lateinit var binding: FragmentAhadeethBinding
    private lateinit var ahadethAdapter: AhadethAdapter
    var ahadeth = mutableListOf<Hadeth>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAhadeethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAhadethRecyclerView()

        readHadethFile()

    }


    private fun initAhadethRecyclerView() {
        Log.e("initAhadethRecyclerView", ahadeth.toString())
        ahadethAdapter = AhadethAdapter(ahadeth) { hadeth, index ->
            val intent = Intent(requireActivity(), HadethDetailsActivity::class.java)
            intent.putExtra(HadethDetailsActivity.HADETH_KEY, hadeth)
            startActivity(intent)
        }
        binding.rvAhadeth.adapter = ahadethAdapter
    }

    private fun readHadethFile() {

        var reader = BufferedReader(
            InputStreamReader(
                requireContext().assets.open("ahadeth/ahadeth.txt"),
                "UTF-8"
            )
        )

        var mLine = reader.readLine()
        val hadeth = mutableListOf<String>()
        while (mLine != null) {
            if (mLine.trim() != "#") {
                hadeth.add(mLine)
            } else {
                val name = hadeth[0]
                hadeth.removeAt(0)
                val content = hadeth.joinToString(" ")
                ahadeth.add(Hadeth(name, content))
                hadeth.clear()
            }
            mLine = reader.readLine()
        }


    }


}