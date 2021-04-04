package com.example.fuproject.activity.ui.home.train

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fuproject.R
import kotlinx.android.synthetic.main.activity_train_radio.*

class TrainRadioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train_radio)
        val uriPeople=Uri.parse("android.resource://$packageName/${R.raw.pass}")
        val uriDo=Uri.parse("android.resource://$packageName/${R.raw.socket}")
        train_radio_people.setVideoURI(uriPeople);
        train_radio_dothings.setVideoURI(uriDo)
        train_radio_play.setOnClickListener {
            if(!train_radio_people.isPlaying){
                train_radio_people.start()
                train_radio_dothings.start()
            }
        }
        train_radio_stop.setOnClickListener {
            if(train_radio_people.isPlaying){
                train_radio_people.pause()
                train_radio_dothings.pause()
            }
        }
        train_radio_reboot.setOnClickListener {
            train_radio_people.resume()
            train_radio_dothings.resume()
        }
        ic_back_train_radio.setOnClickListener {
            finish()
        }
    }
}