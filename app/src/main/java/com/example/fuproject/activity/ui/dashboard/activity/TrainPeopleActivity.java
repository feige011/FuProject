package com.example.fuproject.activity.ui.dashboard.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fuproject.R;

//package com.example.fuproject.activity.ui.dashboard.activity;
//
//import android.content.Context;
//import android.graphics.Rect;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.fuproject.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static androidx.recyclerview.widget.RecyclerView.Adapter;
//import static androidx.recyclerview.widget.RecyclerView.ItemDecoration;
//import static androidx.recyclerview.widget.RecyclerView.LayoutManager;
//import static androidx.recyclerview.widget.RecyclerView.State;
//
public class TrainPeopleActivity extends AppCompatActivity {
//
//
//
//
//
//
////    private TabLayout tabLayout;
//    private RecyclerView recyclerView;
//    private List<TrainClassBean> trainClassBeanList = new ArrayList<TrainClassBean>();
//
//    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_people_train);
//        init();
    }
//
//    private void init() {
//        initControlBind();
//        initData();
//        initRecyclerView();
////        initTabLayout();
//    }
//
//    private void initRecyclerView() {
//        LayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(new TrainPeopleAdapt(this));
//        SpaceItemDecoration decoration = new SpaceItemDecoration(4);
//        recyclerView.addItemDecoration(decoration);
//    }
//
//    private void initControlBind() {
//        recyclerView = (RecyclerView)findViewById(R.id.train_recyclerview);
////        tabLayout = (TabLayout)findViewById(R.id.train_tab_layout);
//    }
//
//    private void initData(){
//        for(int i = 0; i < 10; i++){
//            trainClassBeanList.add(new TrainClassBean("飞哥011","Java高级开发工程师",655233));
//        }
//    }
//
//    private class TrainPeopleAdapt extends Adapter<TrainPeopleAdapt.ViewHolder> {
//
//        private Context context;
//        private LayoutInflater layoutInflater;
//
//        public TrainPeopleAdapt(Context context) {
//            this.context = context;
//            layoutInflater = LayoutInflater.from(context);
//        }
//
//
//        @NonNull
//        @Override
//        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            return new ViewHolder(layoutInflater.inflate(R.layout.item_train_class,parent,false));
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//            holder.name.setText(trainClassBeanList.get(position).getName());
//            holder.mechanism.setText(trainClassBeanList.get(position).getMechanism());
//            holder.number.setText("655233");
//        }
//
//        @Override
//        public int getItemCount() {
//            return trainClassBeanList.size();
//        }
//
//        private class ViewHolder extends RecyclerView.ViewHolder {
//            TextView name;
//            TextView mechanism;
//            TextView number;
//            public ViewHolder(@NonNull View itemView) {
//                super(itemView);
//                name = (TextView)itemView.findViewById(R.id.train_class_name);
//                mechanism = (TextView)itemView.findViewById(R.id.train_class_education);
//                number = (TextView)itemView.findViewById(R.id.train_class_people_number);
//            }
//        }
//    }
//
//    public class SpaceItemDecoration extends ItemDecoration {
//        private int space;
//
//        public SpaceItemDecoration(int space){
//            this.space = space;
//        }
//
//        @Override
//        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull State state) {
//            outRect.top = space;
//            outRect.bottom = space;
//            outRect.left = space * 4;
//            outRect.right = space * 4;
//        }
//    }
//
////    private void initTabLayout() {
////        tabLayout.setUnboundedRipple(true);
////    }
//
}
