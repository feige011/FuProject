package com.example.fuproject.activity.ui.home.train

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.fuproject.AllName
import com.example.fuproject.R
import com.example.fuproject.activity.ui.home.HomeFragment.Companion.PageUserSData
import com.example.fuproject.activity.ui.home.activity.PeoplePastWorkEvaluateBean
import com.example.fuproject.activity.ui.home.activity.TabFragmentDepartment1
import com.example.fuproject.activity.ui.home.activity.TabFragmentDepartment2
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_train_people_activity.*
import java.util.*

class TrainPeopleActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var peoplePastWorkEvaluateBeanList: MutableList<PeoplePastWorkEvaluateBean> =
        ArrayList()

    private val tabs =
        arrayOf("基本信息", "星龙有限公司", "飞毛有限公司", "东强有限公司", "菜行有限公司")
    private val tabFragmentList: MutableList<Fragment> =
        ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train_people_activity)
        init()
    }

    fun initFragment() {
        val tabLayout = findViewById<TabLayout>(R.id.tab_department_layout)
        val viewPager = findViewById<ViewPager>(R.id.view_department_pager)
        userId = intent.getIntExtra("userId", -1)
        departmentName = intent.getStringExtra("departmentName").toString()

        //添加tab
        for (i in tabs.indices) {
//            tabLayout.addTab(tabLayout.newTab().setText(tabs[i]));
            if (i == 0) {
                tabFragmentList.add(
                    TabFragmentDepartment1.newInstance(
                        userId,
                        departmentName
                    )
                )
            } else {

                tabFragmentList.add(TabFragmentDepartment2.newInstance(tabs[i]))
            }

//            if(i==2){
//                tabFragmentList.add(TabFragment3.newInstance(tabs[i]));
//            }else{
//                tabFragmentList.add(TabFragment2.newInstance(tabs[i],i+1));
//            }
        }
        viewPager.adapter = object : FragmentPagerAdapter(
            supportFragmentManager,
            BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        ) {
            override fun getItem(position: Int): Fragment {
                return tabFragmentList[position]
            }

            override fun getCount(): Int {
                return tabFragmentList.size
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return tabs[position]
            }
        }

        //设置TabLayout和ViewPager联动
        tabLayout.setupWithViewPager(viewPager, false)
    }


    fun initAll() {
        userId =
            intent.getIntExtra("userId", -1)
        departmentName =
            intent.getStringExtra("departmentName").toString()
        Log.e(
            "feifei1",
            userId.toString()
        )
        if (userId != -1) {
            val pageUserData =
                PageUserSData
            for ((id1, name1, _, _, _, _, _, _, phoneNumber1, _, _, email1, _, _, _, _, _, _, degree1) in pageUserData) {
                if (id1 == userId) {
                    name =
                        name1
                    //                    people_resume_name.text=pageUser.name
//                    people_resume_gender.text="男"
                    if (degree1 != null) {
                       degree =
                            degree1
                        //                        people_resume_degree.text=pageUser.degree
                    }
                    //                    if (departmentName != null) {
//                        if(departmentName.isNotEmpty()){
//                            people_resume_department.text=departmentName
//                        }
//                    }
                    if (phoneNumber1 != null) {
                        phoneNumber =
                            phoneNumber1
                        //                        people_resume_phone.text=;
                    }
                    if (email1 != null) {
                        email =
                            email1
                    }
                    id =
                        id1
                    break
                }
            }
        }
    }

    private fun init() {
        initControlBind()
        initData()
        initRecyclerView()
    }

    private fun initData() {

        for (i in 0..15) {
            val x = Random().nextInt(AllName.speakNice.size)
            peoplePastWorkEvaluateBeanList.add(
                PeoplePastWorkEvaluateBean(
                    2020,
                    2021,
                    "培训主管"+(i+1),
                    AllName.speakNice[x]
                )
            )
        }
    }

    private fun initControlBind() {
        ic_back_train_people.setOnClickListener {
            finish()
        }
        userId =
            intent.getIntExtra("userId", -1)
        departmentName =
            intent.getStringExtra("departmentName").toString()
        departmentName="实习生"
        recyclerView =
            findViewById<View>(R.id.train_people_work_experience_recyclerview) as RecyclerView
    }

    private fun initRecyclerView() {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = DepartmentPeopleResumeAdapt(this)
    }

    private inner class DepartmentPeopleResumeAdapt(var context: Context) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

            val ITEM_TYPE_HEADER = 0
            val ITEM_TYPE_CONTENT = 1
            val ITEM_TYPE_BOTTOM = 2

        private val layoutInflater: LayoutInflater
        private val headerCount = 1
        private val bottomCount = 1
        val contentItemCount: Int
            get() = peoplePastWorkEvaluateBeanList.size

        fun isHeaderView(position: Int): Boolean {
            return headerCount != 0 && position < headerCount
        }

        fun isBottomView(position: Int): Boolean {
            return bottomCount != 0 && position >= headerCount + contentItemCount
        }

        override fun getItemViewType(position: Int): Int {
            val dataItemCount = contentItemCount
            return if (headerCount != 0 && position < headerCount) {
                ITEM_TYPE_HEADER
            } else if (bottomCount != 0 && position >= headerCount + dataItemCount) {
                ITEM_TYPE_BOTTOM
            } else {
                ITEM_TYPE_CONTENT
            }
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): RecyclerView.ViewHolder {
            if (viewType == ITEM_TYPE_HEADER) {
                return HeaderViewHolder(
                    layoutInflater.inflate(R.layout.item_people_data, parent, false)
                )
            } else if (viewType == ITEM_TYPE_CONTENT) {
                return EvaluateViewHolder(
                    layoutInflater.inflate(R.layout.item_people_work_evaluate, parent, false)
                )
            } else {
                return BottomViewHolder(
                    layoutInflater.inflate(R.layout.item_people_bottom, parent, false)
                )
            }

        }

        override fun onBindViewHolder(
            holder: RecyclerView.ViewHolder,
            position: Int
        ) {
            if (holder is EvaluateViewHolder) {
                holder.tv_company.text =
                    peoplePastWorkEvaluateBeanList[position - headerCount].company
                val workTime = StringBuilder()
                workTime.append("(")
                workTime.append(
                    peoplePastWorkEvaluateBeanList[position - headerCount].startTime
                )
                workTime.append("-")
                workTime.append(
                    peoplePastWorkEvaluateBeanList[position - headerCount].endTime
                )
                workTime.append(")")
                holder.tv_workTime.text =
                    workTime
                holder.tv_evaluate.text =
                    peoplePastWorkEvaluateBeanList[position - headerCount].workEvaluate
                Log.d("dddd", "getItemCount: " + peoplePastWorkEvaluateBeanList.size)
            } else if (holder is HeaderViewHolder) {
            } else if (holder is BottomViewHolder) {
            }
        }

        override fun getItemCount(): Int {
            Log.d(
                "tag",
                (headerCount + contentItemCount + bottomCount).toString()
            )
            return headerCount + contentItemCount + bottomCount
        }



        init {
            layoutInflater = LayoutInflater.from(context)
        }
    }

    private class EvaluateViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tv_company: TextView
        var tv_workTime: TextView
        var tv_evaluate: TextView

        init {
            tv_company =
                itemView.findViewById<View>(R.id.past_work_company) as TextView
            tv_workTime = itemView.findViewById<View>(R.id.past_work_time) as TextView
            tv_evaluate =
                itemView.findViewById<View>(R.id.past_work_evaluate) as TextView
        }
    }

    private class HeaderViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        init {



//        Log.e("feifei1", userId.toString());
//        if (userId != -1) {
//            ArrayList<PageUserSInfoResponseList> pageUserData = HomeFragment.Companion.getPageUserSData();
//            for (PageUserSInfoResponseList pageUser : pageUserData) {
//                if (pageUser.getId() == userId) {
//                    name = pageUser.getName();
//                    if (pageUser.getDegree() != null) {
//                        degree = pageUser.getDegree();
//                    }
//                    if (pageUser.getPhoneNumber() != null) {
//                        phoneNumber = pageUser.getPhoneNumber();
//                    }
//                    if (pageUser.getEmail() != null) {
//                        email = pageUser.getEmail();
//                    }
//                    id = pageUser.getId();
//                    break;
//                }
//            }
//        }
            //进入查看视频
            val startRadio: TextView = itemView.findViewById(R.id.data_start_radio)
            startRadio.setOnClickListener { v: View? ->
                Log.e("feifeiTrain", "点击了")
                val intent = Intent(itemView.context, TrainRadioActivity::class.java)
                itemView.context.startActivity(intent)
            }


            val peopleResumeName =
                itemView.findViewById<TextView>(R.id.people_resume_name)
            peopleResumeName.setText(Companion.name)
            val ResumeGender = itemView.findViewById<TextView>(R.id.people_resume_gender)
            ResumeGender.text = "男"
            val ResumeAge = itemView.findViewById<TextView>(R.id.people_resume_age)
            ResumeAge.text = "18"
            val id = itemView.findViewById<TextView>(R.id.people_resume_id)
            id.setText(Companion.userId.toString())
//            if (Companion.departmentName != null) {
                val department =
                    itemView.findViewById<TextView>(R.id.people_resume_department)
            department.text = Companion.departmentName
//            }
            val rDegree = itemView.findViewById<TextView>(R.id.people_resume_degree)
            rDegree.setText(Companion.degree)
            val phone = itemView.findViewById<TextView>(R.id.people_resume_phone)
            phone.setText(Companion.phoneNumber)
            val rEmail = itemView.findViewById<TextView>(R.id.people_resume_email)
            rEmail.setText(Companion.email)
        }
    }

    private class BottomViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)

    companion object {
        var userId: Int? = null
        var departmentName = "实习生"
            var name = "宇智阳"
        var degree = "本科"
        var phoneNumber = "13478903196"
        var email = "1459419986@qq.com"
        var id = 20190805
    }
}
