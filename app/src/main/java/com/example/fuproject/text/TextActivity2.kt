package com.example.fuproject.text


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fuproject.R
import com.example.fuproject.model.Login
import com.example.fuproject.model.ThingsViewModel
import kotlinx.android.synthetic.main.activity_text3.*
import okhttp3.FormBody
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request


class TextActivity2 : AppCompatActivity() {
//    val FORM_CONTENT_TYPE: MediaType = "application/json;charset=utf-8".toMediaTypeOrNull()!!
    val viewModel by lazy { ViewModelProvider(this).get(ThingsViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text3)
//        19108470019
//        val login=Login("18239806513","123456","",false,1)
//        viewModel.EnterLoginData(login)
        var telSee="";

        textButton.setOnClickListener {
//            val retrofit = Retrofit.Builder()
//                .baseUrl("http://120.55.195.10:8081/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//            val appService: ThingsService = retrofit.create(ThingsService::class.java)
////        appService.searchPage("1","200").enqueue(Object);
//            appService.searchRegister("13478903196", "feige011", "feige011", "682828")
//                .enqueue(object :Callback<RegisterResponse>{
//                    override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
//                        Log.e("feifei","失败了")
//                    }
//
//                    override fun onResponse(
//                        call: Call<RegisterResponse>,
//                        response: Response<RegisterResponse>
//                    ) {
//                        val things = response.body()
//                        if (things != null) {
//                            Log.e("feifei", things.code.toString())
//                            Log.e("feifei", things.message)
//                            Log.e("feifei", things.success.toString())
//                            Log.e("feifei", things.data.toString())
////                Log.e("feifei", things.data.success)
////                Log.e("feifei", things.data.msg)
//                        } else {
//                            Log.e("feifei", "shibai333333")
//                        }
//                    }
//                })

//            try {
//            Thread{
//            val client = OkHttpClient()
//                val requestBody = FormBody.Builder()
//                    .add("phoneNumber","18673107716")
//                    .add("password","feige011")
//                    .add("confirmPassword","feige011")
//                    .add("verificationCode","811032")
//                    .build()

//                val requestBody = FormBody.Builder()
//                    .add("phoneNumber","18239806513")
//                    .add("password","123456")
//                    .add("verificationCode", "")
//                    .add("rememberMe","true")
//                    .add("type","0")
//                    .build()
////                @Field("phoneNumber") phoneNumber: String,
////                @Field("password")  password: String,
////                @Field("verificationCode")  verificationCode: String,
////                @Field("rememberMe") rememberMe: Boolean,
////                @Field("type") type: Int
//                val request = Request.Builder()
//                    .url("http://120.55.195.10:8081/user/login")
//                    .post(requestBody)
//                    .build()
                //创建Request对象



//                val request = Request.Builder()
//                    .url("https://www.baidu.com")
//                    .build()
//                Log.e("feifei","e.message.toString()")
//                val response=client.newCall(request).execute()
//                Log.e("feifei","e.message.toString()")
//                val responseData=response.body?.string()
//                Log.e("feifei","e.message.toString()")
//                if(responseData!=null){
//                    Log.e("feifei","e.message.toString()")
//                    Log.e("responseData",responseData)
//                }else{
//                    Log.e("null","Null")
//                }
//            }.start()
//            }catch (e:Exception){
//                Log.e("feifei2222",e.message.toString())
//            }


//            viewModel.SearchRegister("13478903196","feige011","feige011","682828")
//            viewModel.SearchTelephoneData("18773392767")
            viewModel.SearchTelephoneData("13478903196")
//            viewModel.SearchTelephoneData("18239806513")
//            viewModel.SearchTelephoneData("19108470019")
//            viewModel.SearchTelephoneData("18673107716")
//            18673107716
//            18673107716

//            for(i in 0..100){
////                Thread{
//                    viewModel.SearchTelephoneData("15850786193")
////                }.start()
////                    Log.e("????","?????")
//            }
//            18239806513
//            val retrofit = Retrofit.Builder()
//                .baseUrl("http://120.55.195.10:8081/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//            val appService: ThingsService = retrofit.create(ThingsService::class.java)
//            appService.testTelephone("13478903196").enqueue(object : Callback<TestTelephoneResponse?> {
//                override fun onFailure(call: Call<TestTelephoneResponse?>, t: Throwable) {
//                    Log.e("feifeishibaile","shibaile")
//                }
//
//                override fun onResponse(
//                    call: Call<TestTelephoneResponse?>,
//                    response: Response<TestTelephoneResponse?>
//                ) {
////                    Log.e("feifeichenggong","chenggongle")
//                    val things1: TestTelephoneResponse? = response.body()
//                    if (things1 != null) {
//                        try {
//                            Log.e("feifei", things1.code.toString())
//                            Log.e("feifei", things1.message)
//                            Log.e("feifei", things1.data.toString())
//                            Log.e("feifei", things1.success.toString())
//                        } catch (e: Exception) {
//                            Log.e("feifeishibaile", e.message!!)
//                        }
//                    } else {
//                        Log.e("feifei2", "shibai")
//                    }
//                }
//            })

        }

        registerButton.setOnClickListener {
            Log.e("feier",yanzhengma.text.toString())
            viewModel.SearchRegister("13478903196","feige011","feige011",yanzhengma.text.toString())
        }
        loginButton.setOnClickListener {
            val login:Login=Login("13478903196","feige011","",false,0);
            viewModel.EnterLoginData(login)
        }
        viewModel.placeLoginData.observe(this, Observer {
            val things = it.getOrNull()
            if (things != null) {
//                if (things.code == 200) {
//                    val intent = Intent(this, TextActivity2::class.java)
//                    startActivity(intent)
//                    finish()
//                }
                Log.e("feifeiright", things.code.toString())
                Log.e("feifeiright`", things.data.toString())
                Log.e("feifeiright", things.message)
//                Log.e("feifei", things.data.success)
//                Log.e("feifei", things.data.msg)
            } else {
                Log.e("feifei", "shibai333333")
            }
        })


//        viewModel.SearchRegister()
        viewModel.placeLiveData.observe(this, Observer {
            val things = it.getOrNull()
            if (things != null) {
                if (things.code == 200) {
                    val intent = Intent(this, TextActivity2::class.java)
                    startActivity(intent)
                    finish()
                }
                Log.e("feifei", things.code.toString())
                Log.e("feifei", things.message)
//                Log.e("feifei", things.data.success)
//                Log.e("feifei", things.data.msg)
            } else {
                Log.e("feifei", "shibai333333")
            }
        })

        viewModel.placeTelephoneData.observe(this, Observer {
            val things = it.getOrNull()
            if (things != null) {
                Log.e("feifeiright", things.code.toString())
                Log.e("feifeiright", things.message)
                Log.e("feifeiright", things.data.toString())
                if (things.success) {
                    val intent = Intent(this, TextActivity2::class.java)
                    startActivity(intent)
                    finish()
                }

//                Log.e("feifei", things.data.success)
//                Log.e("feifei", things.data.msg)
            } else {
                Log.e("feifei", "shibai333333")
            }
        })
//        placeTelephoneData
    }
}