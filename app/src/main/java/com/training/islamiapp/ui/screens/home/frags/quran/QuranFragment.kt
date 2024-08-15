package com.training.islamiapp.ui.screens.home.frags.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.training.islamiapp.databinding.FragmentQuranBinding
import com.training.islamiapp.ui.screens.chapter_details.ChapterDetailsActivity
import com.training.islamiapp.ui.utils.Constants

class QuranFragment : Fragment() {

    private lateinit var binding: FragmentQuranBinding
    private lateinit var chaptersAdapter: ChaptersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentQuranBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initChaptersRecyclerView()

    }

    private fun initChaptersRecyclerView() {
        chaptersAdapter = ChaptersAdapter(Constants.chapters) { chapter, index ->
            val intent = Intent(requireActivity(), ChapterDetailsActivity::class.java)
            intent.putExtra(ChapterDetailsActivity.SURA_NAME, chapter.name)
            intent.putExtra(ChapterDetailsActivity.SURA_NUMBER, "${index + 1}.txt")
            startActivity(intent)

        }
        binding.rvChapters.adapter = chaptersAdapter
    }

}