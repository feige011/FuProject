package com.example.fuproject.activity.ui.notifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fuproject.R
import kotlinx.android.synthetic.main.activity_give_money.*

class GiveMoneyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_give_money)
        ic_give_money.setOnClickListener {
            finish()
        }
        Toast.makeText(this,"谢谢好兄弟",Toast.LENGTH_LONG).show()
    }
}