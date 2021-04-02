package com.example.fuproject.activity.ui.home.activity


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fuproject.R


class TabFragmentAdapter(val list: ArrayList<PeoplePastWorkEvaluateBean>) :
    RecyclerView.Adapter<TabFragmentAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val company:TextView=view.findViewById(R.id.past_work_company);
        val evaluate:TextView=view.findViewById(R.id.past_work_evaluate);
        val time:TextView=view.findViewById(R.id.past_work_time);

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_people_work_evaluate ,parent, false)
        val viewHolder= ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val friend = list[position]
        holder.company.text=friend.company
        holder.evaluate.text=friend.workEvaluate
        holder.time.text=friend.endTime.toString();
//        holder.name.text= friend
//        holder.position.text= friend.weidu.toString()
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }
}
