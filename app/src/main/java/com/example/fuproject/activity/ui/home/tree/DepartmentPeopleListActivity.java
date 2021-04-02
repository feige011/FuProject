package com.example.fuproject.activity.ui.home.tree;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fuproject.R;

import java.util.ArrayList;
import java.util.List;

public class DepartmentPeopleListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DepartmentPeopleBean> departmentPeopleBeanList = new ArrayList<DepartmentPeopleBean>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_department_people_list);
        ImageView imageView=findViewById(R.id.ic_back_department_people);
        imageView.setOnClickListener((v)->{
            finish();
        });
        recyclerView = findViewById(R.id.department_people_RecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new DepartmentPeopleListAdapt());
    }

    class DepartmentPeopleListAdapt extends RecyclerView.Adapter<DepartmentPeopleListAdapt.ViewHolder> {

        @NonNull
        @Override
        public DepartmentPeopleListAdapt.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(DepartmentPeopleListActivity.this).inflate(R.layout.item_department_people,parent);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull DepartmentPeopleListAdapt.ViewHolder holder, int position) {
            
        }

        @Override
        public int getItemCount() {
            return departmentPeopleBeanList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}
