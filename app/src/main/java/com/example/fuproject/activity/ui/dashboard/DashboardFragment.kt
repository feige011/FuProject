package com.example.fuproject.activity.ui.dashboard

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fuproject.R
import com.example.fuproject.activity.CompanyActivity
import com.example.fuproject.activity.ui.notifications.NotificationsViewModel
import com.example.fuproject.activity.ui.dashboard.activity.TrainClassBean
import kotlinx.android.synthetic.main.activity_company.*
import kotlinx.android.synthetic.main.layout_people_train.view.*
import java.util.ArrayList

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
    companion object{private val trainClassBeanList: MutableList<TrainClassBean> =
        ArrayList()
    }
    private lateinit var mContext: Context


//    protected override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.layout_people_train)
//
//    }


    private fun init(view:View) {
//        initControlBind(view,recyclerView)
        initData()
        initRecyclerView(view)
//        initTabLayout();
    }

    private fun initRecyclerView(view: View) {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(mContext)
        view.train_recyclerview.setLayoutManager(layoutManager)
        view.train_recyclerview.setAdapter(TrainPeopleAdapt(mContext))
        val decoration = SpaceItemDecoration(4)
        view.train_recyclerview.addItemDecoration(decoration)
    }

//    private fun initControlBind(view:View,recyclerView:RecyclerView) {
//        recyclerView = view.findViewById<View>(R.id.train_recyclerview) as RecyclerView
////        tabLayout = (TabLayout)findViewById(R.id.train_tab_layout);
//    }

    private fun initData() {
        for (i in 0..9) {
            trainClassBeanList.add(TrainClassBean("飞哥011", "Java高级开发工程师", 655233))
        }
    }

    private class TrainPeopleAdapt(private val context: Context) :
        RecyclerView.Adapter<TrainPeopleAdapt.ViewHolder>() {
        private val layoutInflater: LayoutInflater
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ViewHolder {
            return ViewHolder(
                layoutInflater.inflate(
                    R.layout.item_train_class,
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(
            holder: ViewHolder,
            position: Int
        ) {
            holder.name.setText(trainClassBeanList.get(position).getName())
            holder.mechanism.setText(trainClassBeanList.get(position).getMechanism())
            holder.number.text = "655233"
        }

        override fun getItemCount(): Int {
            return trainClassBeanList.size
        }

        private inner class ViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
            var name: TextView
            var mechanism: TextView
            var number: TextView

            init {
                name = itemView.findViewById<View>(R.id.train_class_name) as TextView
                mechanism =
                    itemView.findViewById<View>(R.id.train_class_mechanism) as TextView
                number =
                    itemView.findViewById<View>(R.id.train_class_people_number) as TextView
            }
        }

        init {
            layoutInflater = LayoutInflater.from(context)
        }
    }

    class SpaceItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.top = space
            outRect.bottom = space
            outRect.left = space * 4
            outRect.right = space * 4
        }

    }


    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.layout_people_train, container, false)
        CompanyActivity.activity.user_toolbar_textView.text="人才"
        mContext=context as Context
        init(root)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
//        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }
}