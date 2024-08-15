package com.training.islamiapp.ui.screens.chapter_details

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.training.islamiapp.databinding.ActivityChapterDetailsBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class ChapterDetailsActivity : AppCompatActivity() {

    companion object {
        const val SURA_NAME = "sura_name"
        const val SURA_NUMBER = "sura_number"
    }

    private lateinit var binding: ActivityChapterDetailsBinding

    lateinit var suraName: String
    lateinit var suraNumber: String
    var chapterContent = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        suraName = intent.getStringExtra(SURA_NAME)!!
        suraNumber = intent.getStringExtra(SURA_NUMBER)!!


        readSuraFile()
        binding.tvChapterContent.text = chapterContent

    }

    private fun readSuraFile() {
        var reader = BufferedReader(InputStreamReader(assets.open("quran/$suraNumber"), "UTF-8"))

        // do reading, usually loop until end of file reading
        var mLine = reader.readLine()
        var versenumber = 1
        while (mLine != null) {
            chapterContent += mLine + " {${versenumber}} "
            Log.e("readSura", mLine.toString())
            mLine = reader.readLine()
            versenumber++
        }
    }

}