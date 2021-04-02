package com.example.fuproject.activity.ui.notifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fuproject.R
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.activity_certificate.*
import kotlinx.android.synthetic.main.activity_certificate.view.*

class CertificateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certificate)

        ic_back_certificate.setOnClickListener {
            finish()
        }
    }
}