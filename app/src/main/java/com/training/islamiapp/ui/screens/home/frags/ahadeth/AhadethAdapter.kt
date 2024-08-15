package com.training.islamiapp.ui.screens.home.frags.ahadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.training.islamiapp.databinding.ItemHadethBinding
import com.training.islamiapp.ui.model.Hadeth

class AhadethAdapter(val ahadeth: List<Hadeth>, val onItemClick: (Hadeth, Int) -> Unit) :
    RecyclerView.Adapter<AhadethAdapter.AhadethViewHolder>() {


    inner class AhadethViewHolder(val binding: ItemHadethBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AhadethViewHolder {
        val binding = ItemHadethBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AhadethViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return ahadeth.size
    }

    override fun onBindViewHolder(holder: AhadethViewHolder, position: Int) {
        val hadeth = ahadeth[position]

        holder.binding.apply {
            tvHadethName.text = hadeth.name
            root.setOnClickListener {
                onItemClick(hadeth, position)
            }
        }

    }

}