package com.example.fuproject.activity.ui.dashboard.search;



import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fuproject.R;
import com.example.fuproject.activity.information.data.PieChartData;
import com.example.fuproject.activity.information.view.PieChart;
import com.example.fuproject.activity.ui.home.HomeFragment;
import com.example.fuproject.model.PageUserSInfoResponseList;

import java.util.ArrayList;


public class TabFragmentSearch1 extends Fragment {
    public TabFragmentSearch1(Integer userId, String departmentName) {
        this.userId = userId;
        this.departmentName = departmentName;
    }

    public static TabFragmentSearch1 newInstance(Integer userId, String departmentName) {
        Bundle args = new Bundle();
        TabFragmentSearch1 fragment = new TabFragmentSearch1(userId, departmentName);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.item_people_data, container, false);
        initAll(root);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    Integer userId;
    String departmentName = "人事部";
    String name = "feige011";
    String degree = "本科";
    String phoneNumber = "13478903196";
    String email = "1459419986@qq.com";
    Integer id = 20190805;

    public void initAll(View root) {
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
        if (departmentName.equals("")) {
            TextView mDepartment = root.findViewById(R.id.people_resume_department);
            mDepartment.setText(departmentName);
        }
        TextView mName = root.findViewById(R.id.people_resume_name);
        mName.setText(name);
        if (userId != -1) {
            TextView mId = root.findViewById(R.id.people_resume_id);
            mId.setText(userId.toString());
        }
        TextView mDegree = root.findViewById(R.id.people_resume_degree);
        mDegree.setText(degree);

    }


}


