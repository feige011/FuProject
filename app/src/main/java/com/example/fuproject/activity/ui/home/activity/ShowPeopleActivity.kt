//package com.example.fuproject.activity.ui.home.activity
//
//import android.os.Bundle
//import android.util.Log
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.ViewModelProvider
//import com.example.fuproject.R
//import com.example.fuproject.activity.ui.home.HomeFragment
//import com.example.fuproject.model.ThingsViewModel
//import kotlinx.android.synthetic.main.activity_show_people.*
//import java.text.SimpleDateFormat
//import java.util.*
//
//class ShowPeopleActivity : AppCompatActivity() {
//    val viewModel by lazy { ViewModelProvider(this).get(ThingsViewModel::class.java) }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_show_people)
//        val userId=intent.getIntExtra("userId",-1)
//        val departmentName = intent.getStringExtra("departmentName")
//        Log.e("feifei1",userId.toString())
//        if(userId!=-1){
//            val pageUserData=HomeFragment.PageUserSData
//
//            for(pageUser in pageUserData){
//
//                if(pageUser.id==userId){
//                    people_resume_name.text=pageUser.name
//                    people_resume_gender.text="男"
//                    if(pageUser.degree!=null){
//                        people_resume_degree.text=pageUser.degree
//                    }
//                    if (departmentName != null) {
//                        if(departmentName.isNotEmpty()){
//                            people_resume_department.text=departmentName
//                        }
//                    }
//
//                    val sdf = SimpleDateFormat("yyyy")
//                    val birthday= sdf.format(Date())
//                    Log.e("feifei111",birthday)
//                    Log.e("feifei2","222222"+pageUser.birthDate)
//
//                    if(pageUser.phoneNumber!=null){
//                        people_resume_phone.text=pageUser.phoneNumber
//                    }
//
//
//                    people_resume_age.text="18"
//                    if(pageUser.email!=null){
//                        people_resume_email.text=pageUser.email;
//                    }
//
//                   if(pageUser.id.toString()!=null){
//                       people_resume_id.text=pageUser.id.toString()
//                   }
//
////                    people_resume_position.text=pageUser.
//                    break;
//                }
//            }
//        }
//
//
//    }
//}