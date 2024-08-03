package com.example.islamiapp.hadith

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiapp.R

class HadithAdapter(var ahadith: ArrayList<HadithDM>, var onClick: (HadithDM, Int) -> Unit) :
    Adapter<HadithAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ahadeth_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = ahadith.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hadith = ahadith[position]
        holder.name.text = hadith.name
        holder.itemView.setOnClickListener {
            onClick(hadith, position)
        }
    }


    class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.hadithName)
    }


}