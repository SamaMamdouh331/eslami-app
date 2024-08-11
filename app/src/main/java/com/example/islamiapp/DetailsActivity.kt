package com.example.islamiapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    companion object {
        const val FILE_NAME = "fileName"
        const val TITLE = "title"
    }
    lateinit var fileName: String
    lateinit var title: String
    lateinit var content: TextView
    lateinit var goBack: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        fileName = intent.getStringExtra(FILE_NAME)!!
        title = intent.getStringExtra(TITLE)!!

        val surah: TextView = findViewById(R.id.title)
        content = findViewById(R.id.content)
        surah.text = title
        var description = assets.open(fileName).bufferedReader().use {
            it.readText()
        }
        content.text = description
        goBack = findViewById(R.id.goBack)
        goBack.setOnClickListener {
            finish()
        }

    }
}