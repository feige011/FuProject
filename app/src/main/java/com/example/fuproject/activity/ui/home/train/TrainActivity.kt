package com.example.fuproject.activity.ui.home.train

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.fuproject.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_train.*
import java.util.*

class TrainActivity : AppCompatActivity() {
    private val tabs =
        arrayOf("  前端  ", "  后台  ", "  移动  ", "  嵌入式  ", "  策划  ")
    private val tabFragmentList: ArrayList<Fragment> =
        ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train)
        initFragment()
    }

    fun initFragment() {
        val tabLayout = findViewById<TabLayout>(R.id.tab_train_layout)
        val viewPager = findViewById<ViewPager>(R.id.view_train_pager)
        ic_back_train.setOnClickListener {
            finish()
        }
        //添加tab
        //添加tab
        for (i in tabs.indices) {
//            tabLayout.addTab(tabLayout.newTab().setText(tabs[i]));
            tabFragmentList.add(TrainFragment.newInstance(i))
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

        //设置TabLayout和ViewPager联动
        tabLayout.setupWithViewPager(viewPager, false)
    }
}