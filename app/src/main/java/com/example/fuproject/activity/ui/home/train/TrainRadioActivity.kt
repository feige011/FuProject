package com.example.fuproject.activity.ui.home.train

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fuproject.R
import com.example.fuproject.model.RadioThings
import kotlinx.android.synthetic.main.activity_train_radio.*

class TrainRadioActivity : AppCompatActivity() {
    val list=ArrayList<RadioThings>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train_radio)
        initList()
//        val uriPeople= Uri.parse("android.resource://$packageName/${R.raw.example}")
        ic_back_train_radio.setOnClickListener {
            finish()
        }
        val layoutManager=LinearLayoutManager(this)
        train_radio_recyclerView.layoutManager=layoutManager
        val adapter=TrainRadioAdapter(list)
       train_radio_recyclerView.adapter=adapter
    }
    fun initList(){
        list.add(RadioThings("任务:现场调用音频并排版界面,","android.resource://$packageName/${R.raw.example}"))
        list.add(RadioThings("任务:现场调用卡片布局,并设计界面","android.resource://$packageName/${R.raw.example}"))
        list.add(RadioThings("任务:完成现场对接后台接口","android.resource://$packageName/${R.raw.example}"))
        list.add(RadioThings("任务:完成现场写入安卓数据库信息","android.resource://$packageName/${R.raw.example}"))
        list.add(RadioThings("终极任务:完成现场开发一个天气预报APP","android.resource://$packageName/${R.raw.example}"))
    }
}