package com.example.fuproject.activity.ui.home.help

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fuproject.R
import kotlinx.android.synthetic.main.activity_feedback.*


class FeedbackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        val radioGroup = findViewById<View>(R.id.radioGroup) as RadioGroup

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton =
                group.findViewById<View>(checkedId) as RadioButton
            val result = radioButton.text.toString()
        }

        feedBackButton.setOnClickListener {
            Toast.makeText(this,"提交成功",Toast.LENGTH_SHORT).show()
            finish()
        }
        ic_back_feedback.setOnClickListener {
            finish()
        }
    }
}