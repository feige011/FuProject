package com.example.fuproject.activity.ui.home.help

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fuproject.R
import kotlinx.android.synthetic.main.activity_help.*

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        helpFeedback.setOnClickListener {
            val intent =Intent(this,FeedbackActivity::class.java)
            startActivity(intent)
        }
        ic_back_help.setOnClickListener {
            finish()
        }
    }
}