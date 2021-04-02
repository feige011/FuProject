package com.example.fuproject.activity.ui.dashboard.search;

import android.content.Context;
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
import com.example.fuproject.activity.ui.home.activity.PeoplePastWorkEvaluateBean;
import com.example.fuproject.activity.ui.home.activity.TabFragmentAdapter;
import com.example.fuproject.text.TextRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TabFragmentSearch2 extends Fragment{

    RecyclerView recyclerView;
    ArrayList<PeoplePastWorkEvaluateBean> peoplePastWorkEvaluateBeanList = new ArrayList<PeoplePastWorkEvaluateBean>();
    String meTable="";

    public TabFragmentSearch2(String s) {
        meTable=s;
    }

    public static TabFragmentSearch2 newInstance(String s) {
        Bundle args = new Bundle();
        TabFragmentSearch2 fragment = new TabFragmentSearch2(s);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.layout_department_fragment1, container, false);
        init(root);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void init(View root) {
        initControlBind(root);
        initData();
        initMeRecyclerView();
    }

    private void initMeRecyclerView(){
        TabFragmentAdapter textRecyclerViewAdapter= new TabFragmentAdapter(peoplePastWorkEvaluateBeanList);
//        recyclerView = findViewById<RecyclerView>(R.id.homeRecyclerView)
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(textRecyclerViewAdapter);
    }
    private void getAddList(String s){
        Random random=new Random();
        int x2=random.nextInt(40);
        for (int i = 0; i < x2; i++){
            int x =random.nextInt(AllName.speakNice.length);
            peoplePastWorkEvaluateBeanList.add(new PeoplePastWorkEvaluateBean(2020,2021,s,AllName.speakNice[x]));
        }
    }
    private void initData() {
        switch (meTable){
            case "星龙有限公司":{
                getAddList("星龙有限公司");
                break;
            }
            case "飞毛有限公司":{
                getAddList("飞毛有限公司");
                break;
            }
            case "东强有限公司":{
                getAddList("东强有限公司");
                break;
            }
            case "菜行有限公司":{
                getAddList("菜行有限公司");
                break;
            }


        }
    }

    private void initControlBind(View root) {
        recyclerView = (RecyclerView)root.findViewById(R.id.department_people_work_experience_recyclerview);

    }

    private void initRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new DepartmentPeopleResumeAdapt(getContext()));
    }

    private class DepartmentPeopleResumeAdapt extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        public static final int ITEM_TYPE_HEADER = 0;
        public static final int ITEM_TYPE_CONTENT = 1;
        public static final int ITEM_TYPE_BOTTOM = 2;
        private LayoutInflater layoutInflater;
        Context context;
        private int headerCount = 1;
        private int bottomCount = 1;

        public DepartmentPeopleResumeAdapt(Context context){
            this.context = context;
            layoutInflater = LayoutInflater.from(context);
        }

        public int getContentItemCount(){
            return peoplePastWorkEvaluateBeanList.size();
        }

        public boolean isHeaderView(int position){
            return headerCount != 0 && position < headerCount;
        }

        public boolean isBottomView(int position){
            return bottomCount != 0 && position >= (headerCount + getContentItemCount());
        }

        @Override
        public int getItemViewType(int position) {
            int dataItemCount = getContentItemCount();
            if(headerCount != 0 && position < headerCount){
                return ITEM_TYPE_CONTENT;
            }
            else if (bottomCount != 0 && position >= (headerCount + dataItemCount)){
                return ITEM_TYPE_BOTTOM;
            }
            else {
                return ITEM_TYPE_CONTENT;
            }
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if (viewType == ITEM_TYPE_HEADER){
               HeaderViewHolder holder= new HeaderViewHolder(layoutInflater.inflate(R.layout.item_people_data,parent,false));
                return holder;
//                return new TabFragmentDepartment2.EvaluateViewHolder(layoutInflater.inflate(R.layout.item_people_work_evaluate,parent,false));
            }
            else
            if (viewType == ITEM_TYPE_CONTENT){
                return new EvaluateViewHolder(layoutInflater.inflate(R.layout.item_people_work_evaluate,parent,false));
            }
            else if (viewType == ITEM_TYPE_BOTTOM){
                return new BottomViewHolder(layoutInflater.inflate(R.layout.item_people_bottom,parent,false));
            }

//           if (viewType == ITEM_TYPE_BOTTOM){
//                return new TabFragmentDepartment2.BottomViewHolder(layoutInflater.inflate(R.layout.item_people_bottom,parent,false));
//            }else{
//                return new TabFragmentDepartment2.EvaluateViewHolder(layoutInflater.inflate(R.layout.item_people_work_evaluate,parent,false));
//
//            }
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if(holder instanceof EvaluateViewHolder){
                ((EvaluateViewHolder)holder).tv_company.setText(peoplePastWorkEvaluateBeanList.get(position - headerCount).getCompany());
                StringBuilder workTime = new StringBuilder();
                workTime.append("(");
                workTime.append(peoplePastWorkEvaluateBeanList.get(position - headerCount).getStartTime());
                workTime.append("-");
                workTime.append(peoplePastWorkEvaluateBeanList.get(position - headerCount).getEndTime());
                workTime.append(")");
                ((EvaluateViewHolder)holder).tv_workTime.setText(workTime);
                ((EvaluateViewHolder)holder).tv_evaluate.setText(peoplePastWorkEvaluateBeanList.get(position - headerCount).getWorkEvaluate());
                Log.d("dddd", "getItemCount: " + peoplePastWorkEvaluateBeanList.size());
            }
            else if (holder instanceof HeaderViewHolder){

            }
            else if (holder instanceof BottomViewHolder){

            }
        }

        @Override
        public int getItemCount() {
            Log.d("tag", String.valueOf(headerCount + getContentItemCount() + bottomCount));
            return headerCount + getContentItemCount() + bottomCount;

        }
    }

    private static class EvaluateViewHolder extends RecyclerView.ViewHolder {

        TextView tv_company;
        TextView tv_workTime;
        TextView tv_evaluate;

        public EvaluateViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_company = (TextView)itemView.findViewById(R.id.past_work_company);
            tv_workTime = (TextView)itemView.findViewById(R.id.past_work_time);
            tv_evaluate = (TextView)itemView.findViewById(R.id.past_work_evaluate);
        }
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private static class BottomViewHolder extends RecyclerView.ViewHolder {
        public BottomViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
