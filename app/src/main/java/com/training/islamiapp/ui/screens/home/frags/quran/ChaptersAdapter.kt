package com.training.islamiapp.ui.screens.home.frags.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.training.islamiapp.databinding.ItemSuraBinding
import com.training.islamiapp.ui.model.Chapter

class ChaptersAdapter(val chapters: List<Chapter>, val onItemClick: (Chapter, Int) -> Unit) :
    RecyclerView.Adapter<ChaptersAdapter.ChaptersViewHolder>() {


    inner class ChaptersViewHolder(val binding: ItemSuraBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChaptersViewHolder {
        val binding = ItemSuraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChaptersViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    override fun onBindViewHolder(holder: ChaptersViewHolder, position: Int) {
        val chapter = chapters[position]

        holder.binding.apply {
            tvChapterName.text = chapter.name
            tvChapterVerses.text = chapter.versesNumber.toString()
            root.setOnClickListener {
                onItemClick(chapter, position)
            }
        }

    }

}