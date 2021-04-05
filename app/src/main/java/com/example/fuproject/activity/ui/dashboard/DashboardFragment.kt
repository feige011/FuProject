package com.example.fuproject.activity.ui.dashboard

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fuproject.AllName.Companion.firstName
import com.example.fuproject.AllName.Companion.secondName
import com.example.fuproject.R
import com.example.fuproject.activity.CompanyActivity
import com.example.fuproject.activity.CompanyActivity.Companion.activity
import com.example.fuproject.activity.ui.dashboard.activity.TrainClassBean
import com.example.fuproject.activity.ui.dashboard.search.SearchPeopleBasicActivity
import com.example.fuproject.activity.ui.notifications.NotificationsViewModel
import kotlinx.android.synthetic.main.activity_company.*
import kotlinx.android.synthetic.main.item_train_class.view.*
import kotlinx.android.synthetic.main.layout_people_train.view.*
import java.util.*
import kotlin.collections.ArrayList

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    //
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
////        val textView: TextView = root.findViewById(R.id.text_dashboard)
////        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
////            textView.text = it
////        })
//
//        return root
//    }
    companion object {
        private val trainClassBeanList: MutableList<TrainClassBean> =
            ArrayList()
    }

    private lateinit var mContext: Context


//    protected override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.layout_people_train)
//
//    }


    private fun init(view: View) {
//        initControlBind(view,recyclerView)
        initData()
        initRecyclerView(view, trainClassBeanList as ArrayList<TrainClassBean>)
        initClickSpinner(view)
//        initTabLayout();
    }

    var place = arrayOf("地点", "北京", "上海", "广州", "深圳", "杭州", "长沙", "哈尔滨", "其他")
    var category = arrayOf("类别", "研发人员", "测试人员", "数据分析", "算法人员", "前端人员", "产品人员", "运营人员", "所有")
    val spinnerSort = arrayOf("排序", "最新发布", "金钱", "每周时间", "星级")

    private fun initClickSpinner(view: View) {
//        view.train_spinner_place.onItemSelectedListener=
        var trainClassBeanListTemporary= ArrayList<TrainClassBean>();
        trainClassBeanListTemporary= (trainClassBeanList as ArrayList<TrainClassBean>).clone() as ArrayList<TrainClassBean>
//        var position1=0;
//        var position2=0;
//        var position3=0;
        view.train_spinner_place.setOnItemSelectedListener(object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, v: View, position: Int, id: Long) {

                val meList = ArrayList<TrainClassBean>()
                for (i in trainClassBeanListTemporary) {
                    if (i.place.equals(place[position])) {
                        meList.add(i);
                    }
                }
                if (position != 0) {
                    trainClassBeanListTemporary= meList
                    initRecyclerView(view, meList)
                }else{
                    trainClassBeanListTemporary= (trainClassBeanList as ArrayList<TrainClassBean>).clone() as ArrayList<TrainClassBean>
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })
        view.train_spinner_category.setOnItemSelectedListener(object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, v: View, position: Int, id: Long) {
                val meList = ArrayList<TrainClassBean>()
                for (i in  trainClassBeanListTemporary) {
                    if (position != 8) {
                        if (i.doThings.equals(category[position])) {
                            meList.add(i);
                        }
                    } else {
                        meList.add(i);
                    }

                }
                if (position != 0) {
                    trainClassBeanListTemporary= meList
                    initRecyclerView(view, meList)
                }else{
                    trainClassBeanListTemporary= (trainClassBeanList as ArrayList<TrainClassBean>).clone() as ArrayList<TrainClassBean>
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })

        view.train_spinner_sort.setOnItemSelectedListener(object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, v: View, position: Int, id: Long) {
                val meList = ArrayList<TrainClassBean>()
                when (position) {
                    1 -> {
                        sortTime()
                    }
                    2 -> {
                        sortMoney()
                    }
                    3 -> {
                        sortDoTime()
                    }
                    4 -> {
                        sortStar()
                    }
                }
            }

            private fun sortMoney() {
                Collections.sort(trainClassBeanListTemporary
                    , kotlin.Comparator { o1, o2 ->

                            val xo1 = o1.money.split('-')
                            val x1 = (Integer.parseInt(xo1[0]) + Integer.parseInt(xo1[1])) / 2;
                            val xo2 = o2.money.split('-')
                            val x2 = (Integer.parseInt(xo2[0]) + Integer.parseInt(xo2[1])) / 2;
                            x2-x1
                    })
                initRecyclerView(view, trainClassBeanListTemporary as ArrayList<TrainClassBean>)
            }

            private fun sortDoTime() {
                Collections.sort(trainClassBeanListTemporary
                    , kotlin.Comparator { o1, o2 ->
                        Integer.parseInt(o2.doTime[0].toString()) - Integer.parseInt(o1.doTime[0].toString())
                    })
                initRecyclerView(view, trainClassBeanList as ArrayList<TrainClassBean>)
            }

            private fun sortTime() {
                Collections.sort(trainClassBeanListTemporary
                    , kotlin.Comparator { o1, o2 ->
                        Integer.parseInt(o1.releaseTime[0].toString()) - Integer.parseInt(o2.releaseTime[0].toString())
                    })
                initRecyclerView(view,trainClassBeanListTemporary as ArrayList<TrainClassBean>)
            }

            private fun sortStar() {
                Collections.sort(trainClassBeanListTemporary
                    , kotlin.Comparator { o1, o2 ->
                        Integer.parseInt(o2.recommendedStar) - Integer.parseInt(o1.recommendedStar)
                    })
                initRecyclerView(view,trainClassBeanListTemporary as ArrayList<TrainClassBean>)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })

//        view.train_spinner_sort.setOnItemClickListener { parent, view, position, id ->
//            val meList= ArrayList<TrainClassBean>()
//            for(i in trainClassBeanList){
//                if (position!=8){
//                    if(i.doThings.equals(category[position])){
//                        meList.add(i);
//                    }
//                }else{
//                    meList.add(i);
//                }
//
//            }
//            initRecyclerView(view,meList)
//        }

//        view.train_spinner_sort.setOnItemClickListener { p, v, position, id ->
//            val meList= ArrayList<TrainClassBean>()
//            for(i in trainClassBeanList){
//                if (position!=8){
//                    if(i.doThings.equals(category[position])){
//                        meList.add(i);
//                    }
//                }else{
//                    meList.add(i);
//                }
//
//            }
//            initRecyclerView(view,meList)
//        }


    }

    private fun initRecyclerView(view: View, list: ArrayList<TrainClassBean>) {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(mContext)
        view.train_recyclerview.setLayoutManager(layoutManager)
        view.train_recyclerview.setAdapter(TrainPeopleAdapt(mContext, list))
//        val decoration = SpaceItemDecoration(4)
//        view.train_recyclerview.addItemDecoration(decoration)
    }

//    private fun initControlBind(view:View,recyclerView:RecyclerView) {
//        recyclerView = view.findViewById<View>(R.id.train_recyclerview) as RecyclerView
////        tabLayout = (TabLayout)findViewById(R.id.train_tab_layout);
//    }

    private fun initData() {

        for (i in 0..50) {
            val random = Random()
            var x = random.nextInt(7)
            if (x == 0) {
                x = 1;
            }
            var y = random.nextInt(7)
            if (y == 0) {
                y = 1;
            }
            var firstNameInt=random.nextInt( firstName.length-1)
            var secondNameInt=random.nextInt(secondName.size-1)
            var doTimeInt = random.nextInt(7)
            var releaseTime = random.nextInt(30)
            val startInt = random.nextInt(6);
            var money=random.nextInt(12)
            if(money<3){
                money=money+3
            }
            money=money*1000
            trainClassBeanList.add(
                TrainClassBean(
                    firstName[firstNameInt]+secondName[secondNameInt],
                    "本科",
                    category[x],
                    money.toString()+"-"+(money+1000).toString(),
                    place[y],
                    doTimeInt.toString(),
                    releaseTime.toString(),
                    startInt.toString()
                )
            )
        }
//        trainClassBeanList.add(
//            TrainClassBean(
//                "飞哥011",
//                "本科",
//                "游戏策划",
//                "3000-4000",
//                "北京",
//                "5",
//                "2",
//                "3"
//            )
//        )
    }

    private class TrainPeopleAdapt(
        private val context: Context,
        private val trainClassBeanList: ArrayList<TrainClassBean>
    ) :
        RecyclerView.Adapter<TrainPeopleAdapt.ViewHolder>() {
        private val layoutInflater: LayoutInflater
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_train_class, parent, false)
            view.item_train_cardView.setOnClickListener {
                val intent = Intent(parent.context, SearchPeopleBasicActivity::class.java)
                activity.startActivity(intent)
            }
//            return ViewHolder(
//                layoutInflater.inflate(
//                    R.layout.item_train_class,
//                    parent,
//                    false
//                )
//            )
            return ViewHolder(view);
        }

        override fun onBindViewHolder(
            holder: ViewHolder,
            position: Int
        ) {
            holder.name.text = trainClassBeanList[position].name
            holder.education.text = trainClassBeanList[position].education
            holder.doThings.text = trainClassBeanList[position].doThings;
            holder.money.text = trainClassBeanList[position].money
            holder.place.text = trainClassBeanList[position].place
            holder.doTime.text = trainClassBeanList[position].doTime
            holder.releaseTime.text = trainClassBeanList[position].releaseTime
            holder.recommendedStar.text = trainClassBeanList[position].recommendedStar

        }

        override fun getItemCount(): Int {
            return trainClassBeanList.size
        }

        private inner class ViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
            var name: TextView
            var education: TextView
            var doThings: TextView
            var money: TextView
            var place: TextView
            var doTime: TextView
            var releaseTime: TextView
            var recommendedStar: TextView


            init {
                name = itemView.findViewById<View>(R.id.train_class_name) as TextView
                education =
                    itemView.findViewById<View>(R.id.train_class_education) as TextView
                doThings =
                    itemView.findViewById<View>(R.id.item_train_do) as TextView
                money = itemView.findViewById<View>(R.id.item_train_money) as TextView
                place = itemView.findViewById<View>(R.id.item_train_place) as TextView
                doTime = itemView.findViewById<View>(R.id.item_train_do_time) as TextView
                releaseTime = itemView.findViewById<View>(R.id.item_train_release_time) as TextView
                recommendedStar =
                    itemView.findViewById<View>(R.id.item_train_recommended_star) as TextView
            }
        }

        init {
            layoutInflater = LayoutInflater.from(context)
        }
    }

//    class SpaceItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
//        override fun getItemOffsets(
//            outRect: Rect,
//            view: View,
//            parent: RecyclerView,
//            state: RecyclerView.State
//        ) {
//            outRect.top = space
//            outRect.bottom = space
//            outRect.left = space * 4
//            outRect.right = space * 4
//        }
//
//    }


    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.layout_people_train, container, false)
        CompanyActivity.activity.user_toolbar_textView.text = "人才"
        mContext = context as Context
        init(root)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
//        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }
}