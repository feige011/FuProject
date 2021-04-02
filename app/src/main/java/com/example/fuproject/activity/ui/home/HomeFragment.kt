package com.example.fuproject.activity.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fuproject.R
import com.example.fuproject.activity.CompanyActivity
import com.example.fuproject.activity.information.tab.TabActivity
import com.example.fuproject.activity.ui.home.activity.EmploymentLastActivity
import com.example.fuproject.activity.ui.home.help.HelpActivity
import com.example.fuproject.activity.ui.home.train.TrainActivity
import com.example.fuproject.activity.ui.home.tree.TreeData
import com.example.fuproject.activity.ui.home.tree.TreeListAdapter
import com.example.fuproject.model.*
import com.example.fuproject.network.ServiceCreator
import com.example.fuproject.network.ThingsService
import com.example.fuproject.network.TokenStatic
import com.example.fuproject.network.TokenStatic.Companion.TOKEN
import com.example.fuproject.text.MeDo
import kotlinx.android.synthetic.main.activity_company.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import okhttp3.internal.lockAndWaitNanos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class HomeFragment : Fragment() {
    val viewModel by lazy { ViewModelProvider(this).get(ThingsViewModel::class.java) }


    private lateinit var homeViewModel: HomeViewModel

    fun trainPeople(root:View){
        root.train_people.setOnClickListener {
            val intent=Intent(activity,TrainActivity::class.java)
            startActivity(intent)
        }
    }
    //    val meDo: MeDo = MeDo(this, this)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        root = inflater.inflate(R.layout.fragment_home, container, false)
//        Log.e("feifei",root)
        meDo = MeDo(this, this)
        trainPeople(root)
//        meContext=context
        CompanyActivity.activity.user_toolbar_textView.text="公司"
        root.see_all_information.setOnClickListener {
            val intent=Intent(activity,TabActivity::class.java);
            startActivity(intent)
        }
        root.fragment_help.setOnClickListener {
            val intent=Intent(activity,HelpActivity::class.java)
            startActivity(intent)
        }
        if(PageUserSData.isEmpty()){
            messageThings()
        }



        //注意这里的顺序不能乱 必须按照层级关系添加
//        treeData.add(TreeData("父级1", "1", "0", 0, true))
//        treeData.add(TreeData("子级1", "2", "1", 1, true))
//        treeData.add(TreeData("子级的子级1", "3", "2", 2, false))
//        treeData.add(TreeData("子级的子级2", "4", "0", 2, false))
//        treeData.add(TreeData("父级2", "5", "0", 0, true))
//        treeData.add(TreeData("子级2", "6", "0", 1, false))
//        treeData.add(TreeData("子级3", "7", "0", 1, false))
//        recyclerView = root.findViewById<RecyclerView>(R.id.homeRecyclerView)
//        recyclerView!!.layoutManager = LinearLayoutManager(context)
//        treeListAdapter = TreeListAdapter(context, treeData)
//        recyclerView!!.adapter = treeListAdapter

//        viewModel.getAllUserOfCompanyLiveData.observe(CompanyActivity.lifecycleOwner, Observer {
//            val things = it.getOrNull()
//            if (things != null) {
//                if (things.success) {
//                    pageUserSInfoResponseData=things.data
//                }
//
//                Log.e("feifeiright22", things.code.toString())
//                Log.e("feifeiright22`", things.data.toString())
////                Log.e("")
//                Log.e("feifeiright22", things.message)
//                ViewEmployees(root)
////                Log.e("feifei", things.data.success)
////                Log.e("feifei", things.data.msg)
//            } else {
//                Log.e("feifei", "shibai333333")
//            }
//        })
//        viewModel.GetAllUserOfCompanyData(Page(1,1000))

        viewModel.getAllEmploymentOfCompanyLiveData.observe(
            CompanyActivity.lifecycleOwner,
            Observer {
                val things = it.getOrNull()
                if (things != null) {
//                if (things.success) {
//                    pageUserSInfoResponseData=things.data
//                }

                    Log.e("feifeiright22", things.code.toString())
                    Log.e("feifeiright22`", things.data.toString())
//                Log.e("")
                    Log.e("feifeiright22", things.data.list.toString())
                    Log.e("feifeiright22", things.data.list.toString())
                    Log.e("feifeiright22", things.message)
                    allEmploymentOfCompanyList = things.data.list
                    staticAllEmploymentOfCompanyList=things.data.list as ArrayList<AllEmploymentOfCompany>
//                    mergeAdd(things.data.list, 1, 0, 0)
                    ViewEmployees(root)
//                Log.e("feifei", things.data.success)
//                Log.e("feifei", things.data.msg)
                } else {
                    Log.e("feifei", "shibai333333")
                }
            })
        if(homeAllTreeData.isEmpty()){
            viewModel.GetAllEmploymentOfCompany(Page(1, 1000))
        }else{
            codeMe=0
//            homeAllTreeData=allTreeDate
            allEmploymentOfCompanyList  =staticAllEmploymentOfCompanyList
            doAddAll2(homeAllTreeData,0, 0, 1)
            recyclerView = root.findViewById<RecyclerView>(R.id.homeRecyclerView)
            recyclerView!!.layoutManager = LinearLayoutManager(context)
            treeListAdapter = TreeListAdapter(context, treeData)
            recyclerView!!.adapter = treeListAdapter
        }





        meDo.employment_controller_init()
        //导入公司员工


        root.see_departmen_people.setOnClickListener {

            val intent =Intent(context,EmploymentLastActivity::class.java)
            activity?.startActivity(intent)
//            meDo.SearchEmployment(3)
//            val pageUserSInfo = PageUserSInfo(1, 2, 3);
//            meDo.GetSearchPageUserSInfoData(pageUserSInfo);
//            Repository.searchAllDepartments()
//            val informationDepartmentREST=InformationDepartmentREST("1","1","1");
//            meDo.SearchInformationDepartmentData(informationDepartmentREST);
        }
        return root
    }

//      导入公司员工基本信息
    fun messageThings(){
    viewModel.getAllUserOfCompanyLiveData.observe(
        viewLifecycleOwner,
        Observer {
            val things = it.getOrNull()
            if (things != null) {
//                if (things.success) {
//                    pageUserSInfoResponseData=things.data
//                }

                if(things.success){
                    Log.e("feifeiright223", things.code.toString())
                    Log.e("feifeiright223`", things.data.toString())
//                Log.e("")
                    Log.e("feifeiright223", things.data.list.toString())
                    Log.e("feifeiright223", things.data.list.toString())
                    Log.e("feifeiright223", things.message)
                    PageUserSData=things.data.list as ArrayList<PageUserSInfoResponseList>
                }

//                    allEmploymentOfCompanyList = things.data.list
//                    HomeFragment.staticAllEmploymentOfCompanyList =
//                        things.data.list as ArrayList<AllEmploymentOfCompany>
////                    mergeAdd(things.data.list, 1, 0, 0)
//                    ViewEmployees(HomeFragment.root)
//                Log.e("feifei", things.data.success)
//                Log.e("feifei", things.data.msg)
            } else {
                Log.e("feifei", "shibai333333")
            }
        })
    viewModel.GetAllUserOfCompanyData(Page(1,10000))
}
//    fun isReady(list: List<Departments>): Boolean {
//
//        for (department in list) {
//
//            if (department.children.isEmpty()) {
//                if (mapAdd.get(department.id.toString()) == null) {
//                    return false
//                }
//            } else {
//
////                seeAll(department.children)
//            }
//        }
//        return true
//    }
//    fun isReady(list: List<Departments>): Boolean {
//        for (department in list) {
//            if (department.children.isEmpty()&&mapAdd.get(department.id.toString()) == null) {
//                Log.e("feifei", department.id.toString())
//                return false
//            }
//        }
//        return true
//    }

    fun ViewEmployees(root: View) {
        meDo.InformationDepartmentInit()
        val placeService = ServiceCreator.create(ThingsService::class.java)


//        var list=ArrayList<Departments>();


        placeService.searchAllDepartments(TOKEN)
            .enqueue(object : Callback<AllDepartmentsResponse> {
                override fun onFailure(call: Call<AllDepartmentsResponse>, t: Throwable) {
                    Log.e("feifeiFailure", t.message.toString())
                }

                override fun onResponse(
                    call: Call<AllDepartmentsResponse>,
                    response: Response<AllDepartmentsResponse>
                ) {
                    val things1 = response.body()
                    if (things1 != null) {
//                        for (departments in things1.data.list){
//
//                        }
//                    for(people in things1.data.list){
//                        meDepartment_id=people.id;
//                        Log.e("feifeihahaha",people.id.toString())
//                        val pageUserSInfo= PageUserSInfo(1,5,people.id);
//                        meDo.GetSearchPageUserSInfoData(pageUserSInfo);
//                    }


//                        list=things1.data.list as ArrayList<Departments>
//                    Thread(Runnable {
//                        while (true){
//                            for(people in things1.data.list){
//                                seeAll(things1.data.list);
////                                if(mapAdd[people.id.toString()]==null){
////                                    meDepartment_id=people.id;
////                                    val pageUserSInfo= PageUserSInfo(1,5,people.id);
////                                    meDo.GetSearchPageUserSInfoData(pageUserSInfo);
////                                }
////                                Log.e("feifeihahaha",people.id.toString())
////                                val pageUserSInfo= PageUserSInfo(1,5,people.id);
////                                meDo.GetSearchPageUserSInfoData(pageUserSInfo);
//                            }
//                            if(isReady(things1.data.list)){
//                                break;
//                            }
////                            Log.e("feifeimalegebi","!!!!")
//                            Thread.sleep(500)
//                        }
//                        Log.e("feifeimalegebi","!!!!")

                        Log.e("feifei", things1.success.toString())
                        Log.e("feifei", things1.code.toString())
                        Log.e("feifei", things1.message.toString())
                        Log.e("feifei", things1.data.toString())
                        Log.e("feifei", things1.data.total.toString())

//                        Log.e("feifei", things1.data.list.toString())

//                        addAll(things1.data.list, 1, 0, 0);
                        mergeAdd(things1.data.list, 1, 0, 0)
                        recyclerView = root.findViewById<RecyclerView>(R.id.homeRecyclerView)
                        recyclerView!!.layoutManager = LinearLayoutManager(context)
                        treeListAdapter = TreeListAdapter(context, treeData)
                        recyclerView!!.adapter = treeListAdapter


//                        val msg=Message();
//                        msg.what=1
//                        handler.sendMessage(msg)
//                        recyclerView = root.findViewById<RecyclerView>(R.id.homeRecyclerView)
//                        recyclerView!!.layoutManager = LinearLayoutManager(context)
//                        treeListAdapter = TreeListAdapter(context, treeData)
//                        recyclerView!!.adapter = treeListAdapter
//                    }).start()

//                        Log.e("feifei", things1.success.toString())
//                        Log.e("feifei", things1.code.toString())
//                        Log.e("feifei", things1.message.toString())
//                        Log.e("feifei", things1.data.toString())
//                        Log.e("feifei", things1.data.total.toString())
//                        Log.e("feifei", things1.data.list.toString())
                    } else {
                        Log.e("feifei2222", "shibaifffff")
                    }
                }

            })
    }

    fun mergeAdd(list: List<Departments>, code: Int, code_id: Int, level: Int){
        val allTreeDate = ArrayList<AllTreeDate>()
        addAll2(allTreeDate,list,code, code_id, level);
        codeMe=0
        homeAllTreeData=allTreeDate
        doAddAll2(allTreeDate,code, code_id, level)
    }
    fun addAll2( allTreeDate : ArrayList<AllTreeDate>,list: List<Departments>, code: Int, code_id: Int, level: Int) {
        for (department in list) {
            Log.e("feifeiSee1",
                "department.name=${department.name}  codeMe=${codeMe} code_id=${code_id} level=${level}"
            )
            codeMe += 1
            if (department.children.isEmpty()) {
//                var hasChild = false
                val employmentOfCompanyList = ArrayList<AllEmploymentOfCompany>()
                for (oneEmploymentOfCompanyList in allEmploymentOfCompanyList) {
                    if (oneEmploymentOfCompanyList.userId == department.id) {
                        employmentOfCompanyList.add(oneEmploymentOfCompanyList)
                    }
                }
                allTreeDate.add(AllTreeDate(employmentOfCompanyList,department,ArrayList<AllTreeDate>()))
            } else {
                val employmentOfCompanyList = ArrayList<AllEmploymentOfCompany>()
                for (oneEmploymentOfCompanyList in allEmploymentOfCompanyList) {
                    if (oneEmploymentOfCompanyList.userId == department.id) {
                        employmentOfCompanyList.add(oneEmploymentOfCompanyList)
                    }
                }
                val treeDate=ArrayList<AllTreeDate>()
                addAll2(treeDate,department.children, codeMe, code, level + 1)
                allTreeDate.add(AllTreeDate(employmentOfCompanyList,department,treeDate))

            }
        }

//        for (Departments in list) {
//            val employmentOfCompanyList = ArrayList<AllEmploymentOfCompany>()
////            val allTreeDate=AllTreeDate()
//            for (oneEmploymentOfCompanyList in allEmploymentOfCompanyList) {
//                if (oneEmploymentOfCompanyList.userId == Departments.id) {
//                    employmentOfCompanyList.add(oneEmploymentOfCompanyList)
//                }
//            }
//            allTreeDate.add(AllTreeDate(employmentOfCompanyList, Departments));
//        }


    }

    fun doAddAll2(list:ArrayList<AllTreeDate>, code: Int, code_id: Int, level: Int) {
//        for (tree in allTreeDate) {
            for (allTreeDate in list) {
//                Log.e(
//                    "feifeiSee2",
//                    "department.name=${allTreeDate.departments.name}  codeMe=${codeMe} code_id=${code_id} level=${level}"
//                )
                codeMe += 1
                if (allTreeDate.departments.children.isEmpty()) {
                    Log.e(
                        "feifeiSee2",
                        "name=${allTreeDate.departments.name}  codeMe=${codeMe} code_id=${code_id} level=${level}"
                    )
                    treeData.add(
                        TreeData(
                            allTreeDate.departments.name,
                            codeMe.toString(),
                            code_id.toString(),
                            level,
                            false,
                           null,
                            allTreeDate.departments
                        )
                    )
                    if(allTreeDate.allEmploymentOfCompanyList.isNotEmpty()){
                        for(allEmploymentOfCompany in allEmploymentOfCompanyList){
                            codeMe++;
                            Log.e(
                                "feifeiSee3f",
                                "name=${ allEmploymentOfCompany.name}  codeMe=${codeMe} code_id=${code_id} level=${level}"
                            )
                            treeData.add(
                                TreeData(
                                    allEmploymentOfCompany.name,
                                    codeMe.toString(),
                                    code_id.toString(),
                                    level,
                                    false,
                                    allEmploymentOfCompany,
                                    null
                                )
                            )
                        }
                    }
                } else {
                    Log.e(
                        "feifeiSee2",
                        "name=${allTreeDate.departments.name}  codeMe=${codeMe} code_id=${code_id} level=${level}"
                    )
                    treeData.add(
                        TreeData(
                            allTreeDate.departments.name, codeMe.toString(), code_id.toString(),
                            level,
                            true,
                            null,
                            allTreeDate.departments
                        )
                    )

//                    val x=codeMe;
//                    val y=code

                    if(allTreeDate.allEmploymentOfCompanyList.isNotEmpty()){
                        for(allEmploymentOfCompany in allEmploymentOfCompanyList){
                            Log.e(
                                "feifeiSee3e",
                                "name=${ allEmploymentOfCompany.name}  codeMe=${codeMe} code_id=${code_id} level=${level}"
                            )
                            codeMe++;
                            treeData.add(
                                TreeData(
                                    allEmploymentOfCompany.name,
                                    codeMe.toString(),
                                    code.toString(),
                                    level+1,
                                    false,
                                    allEmploymentOfCompany,
                                    null
                                )
                            )
                        }
                    }
                    doAddAll2(allTreeDate.children, codeMe, code, level + 1)
                }
            }
//        }

    }

    //    private val handler: Handler = Handler(object : Callback() {
//        fun handleMessage(msg: Message): Boolean {
//            //处理消息
//            if (msg.what === 0) {
//            }
//            return false
//        }
//    })
//    val handler=object : Handler(){
//    override fun handleMessage(msg: Message) {
//        when(msg.what){
//            1->{
//                recyclerView = root.findViewById<RecyclerView>(R.id.homeRecyclerView)
//                recyclerView!!.layoutManager = LinearLayoutManager(context)
//                treeListAdapter = TreeListAdapter(context, treeData)
//                recyclerView!!.adapter = treeListAdapter
//            }
//        }
//    }
//    }

    //    lateinit var pageUserSInfoResponseData:PageUserSInfoResponseData
    lateinit var allEmploymentOfCompanyList: List<AllEmploymentOfCompany>
    var treeData: ArrayList<TreeData> = ArrayList()
    companion object {
        var PageUserSData=ArrayList<PageUserSInfoResponseList>()
        var homeAllTreeData =ArrayList<AllTreeDate>()
        lateinit var meDo: MeDo;
        var meName = ""
        var meCode = 0
        var meCode_id = 0
        var meLevel = 0
        var meDepartment_id = 0;
        var codeMe = 0;
        var staticAllEmploymentOfCompanyList=ArrayList<AllEmploymentOfCompany>()
        var mapAdd = HashMap<String, List<PageUserSInfoResponseList>>()
        fun searchPageUserSInfo(id: Int) {
            Log.e("feifeiSee222", "llllll")
            val pageUserSInfo = PageUserSInfo(1, 5, id);
            meDo.GetSearchPageUserSInfoData(pageUserSInfo);
        }


        var recyclerView: RecyclerView? = null
        var treeListAdapter: TreeListAdapter? = null
        lateinit var root: View
        var meContext: Context? = null
//        fun updateTree(id: Int, list: ArrayList<PageUserSInfoResponseList>) {
//            var boolean = false
//            var level = -1
//            var code_id = ""
//            var c = 0
//            var e = "-10"
//            for (data in treeData) {
//                if (id == data.departmentsID) {
//                    boolean = true
//                    level = data.level
//                    code_id = data.code_id
//                    var x = data.code.toInt() + c
//                    tempTreeData.add(
//                        TreeData(
//                            data.name,
//                            x.toString(),
//                            data.code_id,
//                            data.level,
//                            data.hasChild,
//                            data.departmentsID
//                        )
//                    )
//                } else {
//                    if (boolean && level >= data.level && code_id.equals(data.code_id) == false) {
//                        e = data.code
//                        for (pageUser in list) {
//
//                            var x = data.code.toInt() + c
//                            tempTreeData.add(
//                                TreeData(
//                                    pageUser.name,
//                                    x.toString(),
//                                    code_id,
//                                    level,
//                                    false,
//                                    -6
//                                )
//                            )
//                            c++
//                        }
//                        var x = data.code.toInt() + c
//                        var y = data.code_id.toInt()
//                        if (y > e.toInt() && e.toInt() != -10) {
//                            y = y + c
//                        }
//                        tempTreeData.add(
//                            TreeData(
//                                data.name,
//                                x.toString(),
//                                y.toString(),
//                                data.level,
//                                data.hasChild,
//                                data.departmentsID
//                            )
//                        )
//                    } else {
//                        var x = data.code.toInt() + c
////                    var y =data.code_id.toInt()+c
//                        var y = data.code_id.toInt()
//                        if (y > e.toInt() && e.toInt() != -10) {
//                            y = y + c
//                        }
//                        tempTreeData.add(
//                            TreeData(
//                                data.name,
//                                x.toString(),
//                                y.toString(),
//                                data.level,
//                                data.hasChild,
//                                data.departmentsID
//                            )
//                        )
//                    }
//                }
//            }
//            recyclerView = root.findViewById<RecyclerView>(R.id.homeRecyclerView)
//            recyclerView!!.layoutManager = LinearLayoutManager(meContext)
//            treeListAdapter = TreeListAdapter(meContext, treeData)
//            recyclerView!!.adapter = treeListAdapter
//        }

        var arrayList = ArrayList<Departments>()
        var tempArrayList = ArrayList<Departments>()
    }
    var tempTreeData: ArrayList<TreeData> = ArrayList()

//    fun seeAll(list: List<Departments>) {
//
//        for (department in list) {
//            if (department.children.isEmpty() && mapAdd[department.id.toString()] == null) {
//                meDepartment_id = department.id
//                val pageUserSInfo = PageUserSInfo(1, 5, department.id);
//                meDo.GetSearchPageUserSInfoData(pageUserSInfo);
//            } else {
////                hasChild=true
////                treeData.add(
////                    TreeData(
////                        department.name,
////                        codeMe.toString(),
////                        code_id.toString(),
////                        level,
////                        true,
////                        department.id
////                    )
////                )
//                seeAll(department.children)
////                val pageUserSInfo = PageUserSInfo(1, 5, 3);
////                meDo.GetSearchPageUserSInfoData(pageUserSInfo)
//
//            }
//        }
//    }


//    fun addAll(list: List<Departments>, code: Int, code_id: Int, level: Int) {
//
//        for (department in list) {
//
//            Log.e(
//                "feifeiSee",
//                "department.name=${department.name}  codeMe=${codeMe} code_id=${code_id} level=${level}"
//            )
//            codeMe += 1
////            var hasChild:Boolean
//            if (department.children.isEmpty()) {
//                var hasChild = false
////                meName=department.name;
////                meCode=code;
////                meCode_id=code_id;
////                meLevel=level
////                if (mapAdd[department.id.toString()]!!.isEmpty()) {
////                    Log.e("feofei", mapAdd[department.id.toString()].toString())
////                    hasChild = false;
////                } else {
////                    Log.e("feifei", "YouHaiZi?")
////                    hasChild = true;
////                }
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
////                if (hasChild) {
////
////                } else {
////                    hasChild = true
////
////                    for (parent in mapAdd[department.id.toString()]!!) {
////                        Log.e("feifei", "chuxian???")
////                        codeMe += 1
////                        treeData.add(
////                            TreeData(
////                                department.name,
////                                codeMe.toString(),
////                                code_id.toString(),
////                                level,
////                                false,
////                                department.id
////                            )
////                        )
////                    }
////                }
//
////                if(mapAdd[department.id.toString()]){
////                    codeMe += 1
////                    treeData.add(TreeData(department.name, codeMe.toString(), code_id.toString(), level, false,department.id))
////                }
//            } else {
////                hasChild=true
//                treeData.add(
//                    TreeData(
//                        department.name, codeMe.toString(), code_id.toString(),
//                        level,
//                        true,
//                        department.id
//                    )
//                )
//                addAll(department.children, codeMe, code, level + 1)
////                val pageUserSInfo = PageUserSInfo(1, 5, 3);
////                meDo.GetSearchPageUserSInfoData(pageUserSInfo)
//
//            }
//        }
//    }


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
}


//[Departments(id=2, companyId=7, name=技术部, parentId=-1, administratorId=3, isDelete=0,children=[
//Departments(id=31, companyId=7, name=技术部的子部门, parentId=2, administratorId=0, isDelete=0, children=[])]),
//Departments(id=3, companyId=7, name=人事部, parentId=-1, administratorId=3, isDelete=0, children=[
//Departments(id=15, companyId=7, name=测试1, parentId=3, administratorId=3, isDelete=0, children=[]),
//Departments(id=16, companyId=7, name=测试2, parentId=3, administratorId=3, isDelete=0, children=[])]),
//Departments(id=5, companyId=7, name=销售部, parentId=-1, administratorId=3, isDelete=0, children=[Departments(id=29, companyId=7, name=测试3, parentId=5, administratorId=3, isDelete=0, children=[Departments(id=38, companyId=7, name=我的测试部门, parentId=29, administratorId=0, isDelete=0, children=[])])]), Departments(id=6, companyId=7, name=总裁办, parentId=-1, administratorId=3, isDelete=0, children=[])]
