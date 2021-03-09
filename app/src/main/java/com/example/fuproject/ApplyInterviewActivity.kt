package com.example.fuproject

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ApplyInterviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_interview)


        val httpDownloader = HttpDownloader()
        val lrc: String = httpDownloader
            .download("https://lz-upload-001.oss-cn-shenzhen.aliyuncs.com/%E6%A8%A1%E6%9D%BF%E6%96%87%E4%BB%B6.txt")
        Log.e("feifei2",lrc)
        println(lrc)
    }
//    internal class DownloadMp3Listener : View.OnClickListener {
//        override fun onClick(v: View?) {
//            val httpDownloader = HttpDownloader()
//            val result: Int = httpDownloader.downFile(
//                "http://9.125.233.**:8080/mp3/a1.mp3", "voa/", "a1.mp3"
//            )
//            println(result)
//        }
//    }
}