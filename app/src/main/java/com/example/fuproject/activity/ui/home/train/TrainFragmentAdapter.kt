package com.example.fuproject.activity.ui.home.train


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fuproject.R
import com.example.fuproject.activity.ui.home.activity.PeoplePastWorkEvaluateBean
import com.example.fuproject.model.BaseThings
import kotlinx.android.synthetic.main.item_train.view.*
import org.w3c.dom.Text


class TrainFragmentAdapter(val list: ArrayList<BaseThings>) :
    RecyclerView.Adapter<TrainFragmentAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val company:TextView=view.findViewById(R.id.past_work_company);
//        val evaluate:TextView=view.findViewById(R.id.past_work_evaluate);
//        val time:TextView=view.findViewById(R.id.past_work_time);
        val name:TextView=view.findViewById(R.id.tv_hr_employee_item_name);
        val employee:TextView=view.findViewById(R.id.tv_hr_employee_item_section);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_train ,parent, false)
        view.cardTrainPeople.setOnClickListener {
            val intent=Intent(parent.context,TrainPeopleActivity::class.java)
            intent.putExtra("userId",123);
            intent.putExtra("departmentName","feige012")
            parent.context.startActivity(intent)
        }
        val viewHolder= ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val friend = list[position]
        holder.name.text=friend.name
        holder.employee.text=friend.employee
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }
}
