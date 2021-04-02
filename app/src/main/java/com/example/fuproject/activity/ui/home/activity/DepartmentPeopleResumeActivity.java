package com.example.fuproject.activity.ui.home.activity;

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
import com.example.fuproject.model.PageUserSInfoResponseList;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class DepartmentPeopleResumeActivity extends AppCompatActivity {

    private String[] tabs = {"基本信息", "星龙有限公司","飞毛有限公司","东强有限公司","菜行有限公司"};
    private List<Fragment> tabFragmentList = new ArrayList<>();
    public void initFragment(){
        TabLayout tabLayout = findViewById(R.id.tab_department_layout);
        ViewPager viewPager = findViewById(R.id.view_department_pager);
        ImageView back=findViewById(R.id.ic_back_data);
        back.setOnClickListener((v)->{
            this.finish();
        });
        userId=getIntent().getIntExtra("userId",-1);
        departmentName = getIntent().getStringExtra("departmentName");

        //添加tab
        for (int i = 0; i < tabs.length; i++) {
//            tabLayout.addTab(tabLayout.newTab().setText(tabs[i]));
            if(i==0){
                tabFragmentList.add(TabFragmentDepartment1.newInstance(userId,departmentName));
            }else{
                tabFragmentList.add(TabFragmentDepartment2.newInstance(tabs[i]));
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
        setContentView(R.layout.layout_department_people_resume);
        initFragment();
//        initAll();
//        init();

    }
    static Integer userId;
    static String departmentName="人事部";
    static String name="feige011";
    static String degree="本科";
    static String phoneNumber="13478903196";
    static String email="1459419986@qq.com";
    static Integer id=20190805;
    public void initAll(){
        userId=getIntent().getIntExtra("userId",-1);
        departmentName = getIntent().getStringExtra("departmentName");
        Log.e("feifei1",userId.toString());
        if(userId!=-1){
            ArrayList<PageUserSInfoResponseList> pageUserData= HomeFragment.Companion.getPageUserSData();
            for(PageUserSInfoResponseList pageUser : pageUserData){
                if(pageUser.getId()==userId){
                    name=pageUser.getName();
//                    people_resume_name.text=pageUser.name
//                    people_resume_gender.text="男"
                    if(pageUser.getDegree()!=null){
                        degree=pageUser.getDegree();
//                        people_resume_degree.text=pageUser.degree
                    }
//                    if (departmentName != null) {
//                        if(departmentName.isNotEmpty()){
//                            people_resume_department.text=departmentName
//                        }
//                    }
                    if(pageUser.getPhoneNumber()!=null){
                        phoneNumber=pageUser.getPhoneNumber();
//                        people_resume_phone.text=;
                    }
                    if(pageUser.getEmail()!=null){
                        email=pageUser.getEmail();
                    }
                    id=pageUser.getId();
                    break;
                }
            }
        }
    }

    private void init() {
        initControlBind();
        initData();
        initRecyclerView();
    }

    private void initData() {
        for (int i = 0; i < 10; i++){
            peoplePastWorkEvaluateBeanList.add(new PeoplePastWorkEvaluateBean(2014,2015,"星龙科技有限公司","思想上，为人正直，稳定，谦虚。事业心，进取心强，能设身处地为他人着想，热爱集体。"));
        }
    }

    private void initControlBind() {
        recyclerView = (RecyclerView)findViewById(R.id.department_people_work_experience_recyclerview);

    }

    private void initRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new DepartmentPeopleResumeAdapt(this));
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
                return ITEM_TYPE_HEADER;
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
            }
            else if (viewType == ITEM_TYPE_CONTENT){
                return new EvaluateViewHolder(layoutInflater.inflate(R.layout.item_people_work_evaluate,parent,false));
            }
            else if (viewType == ITEM_TYPE_BOTTOM){
                return new BottomViewHolder(layoutInflater.inflate(R.layout.item_people_bottom,parent,false));
            }
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
            TextView peopleResumeName=itemView.findViewById(R.id.people_resume_name);
            peopleResumeName.setText(name);
            TextView ResumeGender =itemView.findViewById(R.id.people_resume_gender);
            ResumeGender.setText("男");
            TextView ResumeAge =itemView.findViewById(R.id.people_resume_age);
            ResumeAge.setText("18");
            TextView id=itemView.findViewById(R.id.people_resume_id);
            id.setText(userId.toString());
            if(departmentName!=null){
                TextView department=itemView.findViewById(R.id.people_resume_department);
                department.setText(departmentName);
            }
            TextView rDegree=itemView.findViewById(R.id.people_resume_degree);
            rDegree.setText(degree);
            TextView phone=itemView.findViewById(R.id.people_resume_phone);
            phone.setText(phoneNumber);
            TextView rEmail=itemView.findViewById(R.id.people_resume_email);
            rEmail.setText(email);

        }
    }

    private static class BottomViewHolder extends RecyclerView.ViewHolder {
        public BottomViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
