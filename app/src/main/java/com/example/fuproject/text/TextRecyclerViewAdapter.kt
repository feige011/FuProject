package com.example.fuproject.text

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fuproject.R


class TextRecyclerViewAdapter(val list: ArrayList<String>) :
    RecyclerView.Adapter<TextRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.text_recyclerview_textview)
//        val position: TextView = view.findViewById(R.id.member_text_wei)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.text_layout_recyclerview ,parent, false)
        val viewHolder= ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val friend = list[position]
        holder.name.text= friend
//        holder.position.text= friend.weidu.toString()
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }
}