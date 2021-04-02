package com.example.fuproject.activity.ui.home.train;



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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fuproject.AllName;
import com.example.fuproject.R;
import com.example.fuproject.activity.information.data.PieChartData;
import com.example.fuproject.activity.information.view.PieChart;
import com.example.fuproject.activity.ui.home.HomeFragment;
import com.example.fuproject.activity.ui.home.activity.PeoplePastWorkEvaluateBean;
import com.example.fuproject.activity.ui.home.activity.TabFragmentAdapter;
import com.example.fuproject.model.BaseThings;
import com.example.fuproject.model.PageUserSInfoResponseList;

import java.util.ArrayList;
import java.util.Random;


public class TrainFragment extends Fragment {
    int id;

    public TrainFragment(int id) {
        this.id=id;
    }

    public static TrainFragment newInstance(int id) {
        Bundle args = new Bundle();
        TrainFragment fragment = new TrainFragment(id);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.layout_department_fragment1, container, false);
        initAll(root);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
    RecyclerView recyclerView;
    ArrayList<BaseThings> peoplePastWorkEvaluateBeanList = new ArrayList<>();
    private void initControlBind(View root) {
        recyclerView = (RecyclerView)root.findViewById(R.id.department_people_work_experience_recyclerview);
    }
    private void initData() {
        peoplePastWorkEvaluateBeanList.clear();
        switch (id){
            case 0:{
                for (int i = 0; i < 25; i++){
                    Random random=new Random();
                    int f=random.nextInt(AllName.firstName.length()-1);
                    int s=random.nextInt(AllName.secondName.length-1);
                    peoplePastWorkEvaluateBeanList.add(new BaseThings(AllName.firstName.charAt(f)+AllName.secondName[s],"前端"));
                }
                break;
            }
            case 1:{
                for (int i = 0; i < 20; i++){
                    Random random=new Random();
                    int f=random.nextInt(AllName.firstName.length()-1);
                    int s=random.nextInt(AllName.secondName.length-1);
                    peoplePastWorkEvaluateBeanList.add(new BaseThings(AllName.firstName.charAt(f)+AllName.secondName[s],"后台"));
                }
                break;
            }
            case 2:{
                for (int i = 0; i < 21; i++){
                    Random random=new Random();
                    int f=random.nextInt(AllName.firstName.length()-1);
                    int s=random.nextInt(AllName.secondName.length-1);
                    peoplePastWorkEvaluateBeanList.add(new BaseThings(AllName.firstName.charAt(f)+AllName.secondName[s],"移动"));
                }
                break;
            }
            case 3:{
                for (int i = 0; i < 15; i++){
                    Random random=new Random();
                    int f=random.nextInt(AllName.firstName.length()-1);
                    int s=random.nextInt(AllName.secondName.length-1);
                    peoplePastWorkEvaluateBeanList.add(new BaseThings(AllName.firstName.charAt(f)+AllName.secondName[s],"嵌入式"));
                }
                break;
            }
            case 4:{
                for (int i = 0; i < 15; i++){
                    Random random=new Random();
                    int f=random.nextInt(AllName.firstName.length()-1);
                    int s=random.nextInt(AllName.secondName.length-1);
                    peoplePastWorkEvaluateBeanList.add(new BaseThings(AllName.firstName.charAt(f)+AllName.secondName[s],"策划"));
                }
                break;
            }
        }

    }
    public void initAll(View root) {
        initControlBind(root);
        initData();
        TrainFragmentAdapter textRecyclerViewAdapter= new TrainFragmentAdapter(peoplePastWorkEvaluateBeanList);
//        recyclerView = findViewById<RecyclerView>(R.id.homeRecyclerView)
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(textRecyclerViewAdapter);
    }


}


