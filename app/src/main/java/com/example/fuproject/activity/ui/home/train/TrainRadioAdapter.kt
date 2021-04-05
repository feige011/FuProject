package com.example.fuproject.activity.ui.home.train




import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.fuproject.R
import com.example.fuproject.activity.ui.home.activity.PeoplePastWorkEvaluateBean
import com.example.fuproject.model.BaseThings
import com.example.fuproject.model.RadioThings
import kotlinx.android.synthetic.main.activity_train_radio.*
import kotlinx.android.synthetic.main.item_train.view.*
import kotlinx.android.synthetic.main.item_train_radio_recyclerview.view.*
import org.w3c.dom.Text


class TrainRadioAdapter(val list: ArrayList<RadioThings>) :
    RecyclerView.Adapter<TrainRadioAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //        val company:TextView=view.findViewById(R.id.past_work_company);
//        val evaluate:TextView=view.findViewById(R.id.past_work_evaluate);
//        val time:TextView=view.findViewById(R.id.past_work_time);
        val things:TextView=view.findViewById(R.id.train_radio_recyclerView_tv);
        val radio: VideoView =view.findViewById(R.id.train_radio_example);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_train_radio_recyclerview ,parent, false)


        view.train_radio_play.setOnClickListener {
            if(!view.train_radio_example.isPlaying){
                view.train_radio_example.start()
            }
        }
        view.train_radio_stop.setOnClickListener {
            if(view.train_radio_example.isPlaying){
                view.train_radio_example.pause()
            }
        }
        view.train_radio_reboot.setOnClickListener {
            view.train_radio_example.resume()

        }


        val viewHolder= ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val friend = list[position]
        val uriPeople= Uri.parse(friend.url)
        holder.radio.setVideoURI(uriPeople);
        holder.things.text=friend.things
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }
}
