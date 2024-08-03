package com.example.islamiapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.DetailsActivity
import com.example.islamiapp.R
import com.example.islamiapp.hadith.HadithAdapter
import com.example.islamiapp.hadith.HadithConstant
import com.example.islamiapp.hadith.HadithDM

class HadethFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var ahadith: ArrayList<HadithDM>
    lateinit var adapter: HadithAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_hadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.HadithRecycler)

        initHadith()

        adapter = HadithAdapter(ahadith) { ahadith, index ->
            val intent = Intent(context, DetailsActivity::class.java).apply {
                putExtra(DetailsActivity.TITLE, ahadith.name)
                putExtra(DetailsActivity.FILE_NAME, "h${index + 1}.txt")
            }
            startActivity(intent)

        }
        recyclerView.adapter = adapter

    }

    fun initHadith() {
        ahadith = ArrayList()
        HadithConstant.ahadithName.forEachIndexed { index, item ->
            ahadith.add(HadithDM(item))
        }
    }
}