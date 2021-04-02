package com.example.fuproject.activity.ui.notifications

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fuproject.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        ic_back_about.setOnClickListener {
            finish()
        }
        about_give.setOnClickListener {
            val intent=Intent(this,GiveMoneyActivity::class.java)
            startActivity(intent)
        }
    }
}