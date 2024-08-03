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
import com.example.islamiapp.quraan.QuraanAdapter
import com.example.islamiapp.quraan.QuraanDM
import com.example.islamiapp.quraan.quraanConstants

class QuraanFragment : Fragment() {
    lateinit var adapter: QuraanAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var quraanList: ArrayList<QuraanDM>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_main_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.quraanRecycler)
        initNames()
        adapter = QuraanAdapter(quraanList) { quraan, index ->
            val intent = Intent(requireActivity(), DetailsActivity::class.java).apply {
                putExtra(DetailsActivity.TITLE, quraan.name)
                putExtra(DetailsActivity.FILE_NAME, "${index + 1}.txt")
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter

    }

    fun initNames() {
        quraanList = ArrayList()
        quraanConstants.sewerName.forEachIndexed { index, item ->
            quraanList.add(QuraanDM(item, index + 1))
        }
    }
}


