package com.training.islamiapp.ui.screens.hadeth_details

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.training.islamiapp.databinding.ActivityHadethDetailsBinding
import com.training.islamiapp.ui.model.Hadeth

class HadethDetailsActivity : AppCompatActivity() {

    companion object {
        const val HADETH_KEY = "hadeth"
    }

    lateinit var hadeth: Hadeth

    private lateinit var binding: ActivityHadethDetailsBinding


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        hadeth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(HADETH_KEY, Hadeth::class.java)!!
        } else {
            intent.getSerializableExtra(HADETH_KEY) as Hadeth
        }


        binding.tvHadethContent.text = hadeth.content


    }
}