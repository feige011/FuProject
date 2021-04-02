package com.example.fuproject.activity.ui.dashboard.search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.fuproject.R;
import com.example.fuproject.activity.information.tab.TabFragment2;
import com.example.fuproject.activity.information.tab.TabFragment3;
import com.example.fuproject.activity.ui.home.HomeFragment;
import com.example.fuproject.activity.ui.home.activity.PeoplePastWorkEvaluateBean;
import com.example.fuproject.activity.ui.home.activity.TabFragmentDepartment1;
import com.example.fuproject.activity.ui.home.activity.TabFragmentDepartment2;
import com.example.fuproject.model.PageUserSInfoResponseList;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchPeopleBasicActivity extends AppCompatActivity {

    private String[] tabs = {"基本信息", "星龙有限公司","飞毛有限公司","东强有限公司","菜行有限公司"};
    private List<Fragment> tabFragmentList = new ArrayList<>();
    public void initFragment(){
        TabLayout tabLayout = findViewById(R.id.tab_search_basic_layout);
        ViewPager viewPager = findViewById(R.id.view_search_basic_pager);
        ImageView backBasic=findViewById(R.id.ic_back_search_basic);
        backBasic.setOnClickListener((v)->{
            finish();
        });
        userId=0;
        departmentName = "无";
        //添加tab
        Random random=new Random();
        int x=random.nextInt(4)+1;

        for (int i = 0; i < x; i++) {
//            tabLayout.addTab(tabLayout.newTab().setText(tabs[i]));
            if(i==0){
                tabFragmentList.add(TabFragmentSearch1.newInstance(userId,departmentName));
            }else{
                tabFragmentList.add(TabFragmentSearch2.newInstance(tabs[i]));
            }

//            if(i==2){
//                tabFragmentList.add(TabFragment3.newInstance(tabs[i]));
//            }else{
//                tabFragmentList.add(TabFragment2.newInstance(tabs[i],i+1));
//            }
        }
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return tabFragmentList.get(position);
            }
            @Override
            public int getCount() {
                return tabFragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tabs[position];
            }
        });

        //设置TabLayout和ViewPager联动
        tabLayout.setupWithViewPager(viewPager,false);
    }



    RecyclerView recyclerView;
    List<PeoplePastWorkEvaluateBean> peoplePastWorkEvaluateBeanList = new ArrayList<PeoplePastWorkEvaluateBean>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_people_basic);
        initFragment();
//        initAll();
//        init();

    }
    static Integer userId;
    static String departmentName="无";
    static String name="feige011";
    static String degree="本科";
    static String phoneNumber="13478903196";
    static String email="1459419986@qq.com";
}
