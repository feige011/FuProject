package com.example.fuproject.text

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.fuproject.JobActivity
import com.example.fuproject.LoginActivity
import com.example.fuproject.RegisterActivity
import com.example.fuproject.activity.CompanyActivity
import com.example.fuproject.activity.ui.home.HomeFragment
import com.example.fuproject.activity.ui.home.tree.TreeData

import com.example.fuproject.model.*
import com.example.fuproject.network.TokenStatic
import kotlin.concurrent.thread


class MeDo(val owner: ViewModelStoreOwner, val life: LifecycleOwner) : AppCompatActivity() {
    lateinit var context: Context;


    //    lateinit var activity: Activity;
//    val updateText=1
//    val handler=object : Handler(){
//        override fun handleMessage(msg:Message){
//            when(msg.what){
//                updateText->{
//                    Log.e("feifei??aaa",context.toString())
//                    val intent =Intent(context,CompanyActivity::class.java)
//                    startActivity(intent)
//                }
//            }
//        }
//    }
    val viewModel by lazy { ViewModelProvider(owner).get(ThingsViewModel::class.java) }

    fun rememberMe(isRemember: Boolean) {
        val prefs = getPreferences(Context.MODE_PRIVATE)
        if (isRemember) {
            val account = prefs.getString("account", "")
            val password = prefs.getString("password", "")

        }
    }


    fun init(activity: LoginActivity) {
        viewModel.placeLoginData.observe(life, Observer {
            val things = it.getOrNull()
            if (things != null) {
                if (things.success) {
                    TokenStatic.TOKEN = things.data["token"].toString()
                    Log.e("feifei", "token=" + TokenStatic.TOKEN)
                    try {
//                        val intent =Intent(activity,CompanyActivity::class.java)
//                    startActivity(intent)
//                        thread {
//                            context=context2
//                            val msg=Message()
//                            msg.what=updateText
//                            handler.sendMessage(msg)
//                        }
//                        val loginActivity=LoginActivity()
                        activity.intentCompany()
                    } catch (e: Exception) {
                        Log.e("feifei??aaa", e.message.toString())
                    }

                }
                Log.e("feifeiright", things.code.toString())
                Log.e("feifeiright`", things.data.toString())
//                Log.e("")
                Log.e("feifeiright", things.message)

//                Log.e("feifei", things.data.success)
//                Log.e("feifei", things.data.msg)
            } else {
                Log.e("feifei", "shibai333333")
            }
        })

//
////        viewModel.SearchRegister()
//        viewModel.placeLiveData.observe(life, Observer {
//            val things = it.getOrNull()
//            if (things != null) {
//                if (things.code == 200) {
//                    val intent = Intent(this, TextActivity2::class.java)
//                    startActivity(intent)
//                    finish()
//                }
//                Log.e("feifei", things.code.toString())
//                Log.e("feifei", things.message)
////                Log.e("feifei", things.data.success)
////                Log.e("feifei", things.data.msg)
//            } else {
//                Log.e("feifei", "shibai333333")
//            }
//        })
//
//        viewModel.placeTelephoneData.observe(life, Observer {
//            val things = it.getOrNull()
//            if (things != null) {
//                Log.e("feifeiright", things.code.toString())
//                Log.e("feifeiright", things.message)
//                Log.e("feifeiright", things.data.toString())
////                Log.e("feifei", things.data.success)
////                Log.e("feifei", things.data.msg)
//            } else {
//                Log.e("feifei", "shibai333333")
//            }
//        })
    }

//    fun initCompanyLiveData()


    fun initRegister(activity: RegisterActivity) {



//        viewModel.SearchRegister()
        viewModel.placeLiveData.observe(life, Observer {
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

        viewModel.placeTelephoneData.observe(life, Observer {
            val things = it.getOrNull()
            if (things != null) {
                Log.e("feifeiright", things.code.toString())
                Log.e("feifeiright", things.message)
                Log.e("feifeiright", things.data.toString())
//                Log.e("feifei", things.data.success)
//                Log.e("feifei", things.data.msg)
            } else {
                Log.e("feifei", "shibai333333")
            }
        })
    }
    fun searchPhone(phone:String){
        viewModel.SearchTelephoneData(phone)
    }
    fun searchRegister(phoneNumber:String, password:String, confirmPassword:String, verificationCode:String){
        viewModel.SearchRegister(phoneNumber,password, confirmPassword, verificationCode)
    }

    fun InformationDepartmentInit() {
        viewModel.placesearchInformationDepartmentData.observe(life, Observer {
            val things = it.getOrNull()
            if (things != null) {
                Log.e("feifeiright", things.code.toString())
                Log.e("feifeiright", things.message)
                Log.e("feifeiright", things.data.toString())
                Log.e("feifeiright", things.success.toString())
//                Log.e("feifei", things.data.success)
//                Log.e("feifei", things.data.msg)
            } else {
                Log.e("feifei", "shibai333333")
            }
        })
    }

    fun SearchInformationDepartmentData(informationDepartmentREST: InformationDepartmentREST) {
        Log.e("feifei", "dianjile")
        viewModel.SearchInformationDepartmentData(informationDepartmentREST)
    }


    fun EnterLoginData(login: Login) {
//        Log.e("!!!","```");
        viewModel.EnterLoginData(login)
//        enterLoginData.value = login
    }
//    val enterLoginData = MutableLiveData<Login>()
//    //    val placeList = ArrayList<ThingsMe>()
//    val placeLoginData = Transformations.switchMap(enterLoginData) {
//        Log.e("feifei", "shibai")
//        Repository.enterLogin(it)
//    }

    //    val homeFragment=HomeFragment()
    //初始化查看员工
    fun employment_controller_init() {
        viewModel.getSearchEmploymentData.observe(life, Observer {
            val things = it.getOrNull();
            if (things != null) {
                Log.e("feifeiright", things.code.toString())
                Log.e("feifeiright", things.message)
                Log.e("feifeiright", things.data.toString())
            } else {
                Log.e("feifei", "shibai333333")
            }
        })
        // 【部门员工入职信息列表】分页查询部门人员基本信息
        viewModel.getSearchPageUserSInfoData.observe(life, Observer {
            Log.e("feifeicao","查找了")
            val things = it.getOrNull();
//            HomeFragment.treeData.add(
//                TreeData(
//                    HomeFragment.meName,
//                    HomeFragment.codeMe.toString(),
//                    HomeFragment.meCode_id.toString(),
//                    HomeFragment.meLevel,
//                    false,
//                    HomeFragment.meDepartment_id
//                )
//            )
            Log.e("feifeierchanggeong?","wocao rilegoule")
            if (things != null) {
//                var meName=""
//                var meCode=0
//                var meCode_id=0
//                var meLevel=0
//                var meDepartment_id=0;
                Log.e("feifeierchanggeong?","wocao rilegoule")


                if (things.success) {
//                    TreeListAdapter.createPeople(TreeListAdapter.recyclerView,things.data.list,1, 0, 0)
                    Log.e("feifeiqingqiuchenggong",HomeFragment.meDepartment_id.toString())
                    Log.e("feifeiqingqiuchenggong",things.data.list.toString())
//                    TreeListAdapter.createPeople2(TreeListAdapter.recyclerView)

//                    HomeFragment.updateTree(HomeFragment.meDepartment_id,things.data.list as ArrayList<PageUserSInfoResponseList>)
//                    things.data.
//                    Log.e("feifeierchanggeong?","11111")
//                    HomeFragment.mapAdd.set(HomeFragment.meDepartment_id.toString(),things.data.list)
//                    Log.e("feifeierchanggeong?",HomeFragment.meDepartment_id.toString()+"  "+ HomeFragment.mapAdd[HomeFragment.meDepartment_id.toString()].toString())
//                    for (PageUserSInfoResponseList in things.data.list) {
//                        HomeFragment.codeMe++
//                        HomeFragment.treeData.add(
//                            TreeData(
//                                PageUserSInfoResponseList.name,
//                                HomeFragment.codeMe.toString(),
//                                HomeFragment.meCode_id.toString(),
//                                HomeFragment.meLevel,
//                                false,
//                                HomeFragment.meDepartment_id
//                            )
//                        )
//                    }

//                    var meName=""
//                    var meCode=0
//                    var meCode_id=0
//                    var meLevel=0
//                    var meDepartment_id=0;
//                    var codeMe = 0;
//                        fff()
//                        val homeFragment:HomeFragment=HomeFragment();
//                    homeFragment.addEmployments(things.data.list,HomeFragment.meCode,HomeFragment.meCode_id,HomeFragment.meLevel)
                } else {
//                    val p=PageUserSInfoResponseList(0.0,"0","0",0.0,0.0,"0","0",0.0,"0","0","0","0","0","0","0","0",0.0,"0","0","0","0",0.0,"0","0",0.0,"0")
////                    Log.e("feifeierchanggeong?","2222")
//                    val list=ArrayList<PageUserSInfoResponseList>()
////                    list.add(p);
//                    HomeFragment.mapAdd.set(HomeFragment.meDepartment_id.toString(), list)
//                    Log.e("feifeierchanggeong!!!",HomeFragment.meDepartment_id.toString()+"  "+ HomeFragment.mapAdd[HomeFragment.meDepartment_id.toString()].toString())
//                    //                    HomeFragment.treeData.add(TreeData(HomeFragment.department.name, homeFragment.codeMe.toString(), code_id.toString(), level, true, department.id))
                }

            } else {
                Log.e("feifeierchanggeong?", "shibai333333")
            }
        })
    }


//    fun addEmployments(list:List<PageUserSInfoResponseList>, code: Int, code_id: Int, level: Int) {
//        for (department in list) {
//            Log.e("feifeiSee", "department.name=${department.name}  codeMe=${codeMe} code_id=${code_id} level=${level}")
//            codeMe += 1
////            var hasChild:Boolean
//            if (department.children.isEmpty()) {
////               hasChild=false
//                meName=department.name;
//                meCode=codeMe;
//                meCode_id=code_id;
//                meLevel=level
//                meDepartment_id=department.id
//                val pageUserSInfo= PageUserSInfo(1,2,department.id);
//                meDo.GetSearchPageUserSInfoData(pageUserSInfo);
//                treeData.add(TreeData(department.name, codeMe.toString(), code_id.toString(), level, false,department.id))
//            } else {
////                hasChild=true
//                treeData.add(
//                    TreeData(
//                        department.name,
//                        codeMe.toString(),
//                        code_id.toString(),
//                        level,
//                        true,
//                        department.id
//                    )
//                )
//                addAll(department.children, codeMe, code, level + 1)
//                val pageUserSInfo= PageUserSInfo(1,5,3);
//                meDo.GetSearchPageUserSInfoData(pageUserSInfo)
//
//            }
//        }
//    }


    fun GetSearchPageUserSInfoData(pageUserSInfo: PageUserSInfo) {
        viewModel.SearchPageUserSInfoData(pageUserSInfo)
    }

    fun SearchEmployment(use_id: Int) {
        viewModel.SearchEmployment(use_id)
    }

}