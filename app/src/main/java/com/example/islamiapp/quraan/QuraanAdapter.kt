package com.example.islamiapp.quraan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiapp.R

class QuraanAdapter(
    var quraanList: ArrayList<QuraanDM>,
    val onClick: (QuraanDM, Int) -> Unit
) :
    Adapter<QuraanAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quraan_menu, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = quraanList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val quraanDM = quraanList[position]
        holder.name.text = quraanDM.name
        holder.number.text = quraanDM.number.toString()
        holder.itemView.setOnClickListener {
            onClick(quraanDM, position)
        }
    }

    class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.sewerName)
        val number: TextView = itemView.findViewById(R.id.AyatNumber)
    }
}