package com.example.fuproject.activity.ui.home.tree;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fuproject.R;
import com.example.fuproject.activity.ui.home.HomeFragment;
import com.example.fuproject.activity.ui.home.activity.EmploymentLastActivity;
import com.example.fuproject.activity.ui.home.tree.BaseViewHolder;
import com.example.fuproject.model.AllDepartmentsResponse;
import com.example.fuproject.model.PageUserSInfo;
import com.example.fuproject.model.PageUserSInfoResponse;
import com.example.fuproject.model.PageUserSInfoResponseList;
import com.example.fuproject.network.ThingsService;
import com.example.fuproject.network.TokenStatic;
import com.example.fuproject.text.TextRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TreeListAdapter extends RecyclerView.Adapter<BaseViewHolder>
{
    //上下文
    private Context contextx;

    //列表的所有项
    private List<TreeData> allList;
    //列表需要显示的项
    private List<TreeData> ShownList;

    //父节点的ID,如果该节点展开就把节点的ID存储在这
    private List<String> shrinkIdList;

    private int level;



    public TreeListAdapter(Context ctx, List<TreeData> allList)
    {
        this.contextx = ctx;
        this.allList = allList;
        ShownList = new ArrayList<>(allList.size());
        shrinkIdList = new ArrayList<>();


//        这段注释是把所有负极添加进 shrinkIdList里面让其全部展开 否则全部关闭
        /*
            for (int i=0;i<allList.size();i++)
            {
                if (allList.get(i).getHasChild())
                {
                    shrinkIdList.add(allList.get(i).getCode());
                }
            }*/
        listProcessing();
    }



    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BaseViewHolder(LayoutInflater.from(contextx).inflate(R.layout.item_tree_list,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int position)
    {
        final TreeData treeData = ShownList.get(position);

        LinearLayout linearLayout = baseViewHolder.getView(R.id.tree_item);
        TextView tvCompanyName = baseViewHolder.getView(R.id.tv_company_name);
        tvCompanyName.setText(treeData.getName());
        ImageView leftImg = baseViewHolder.getView(R.id.iv_spread_level_0);

//        recyclerView=baseViewHolder.getView(R.id.tree_list_recyclerview);



        level = treeData.getLevel();
        boolean hasChild = treeData.getHasChild();

        if(hasChild)
        {
            //判断该级是否有子级如果有把左边的图标显示
            leftImg.setVisibility(View.VISIBLE);
//            根据是否展开显示对应的图标
            if(shrinkIdList.contains(treeData.getCode()))
            {
                leftImg.setImageResource(R.drawable.down_gray);

            } else
            {
                leftImg.setImageResource(R.drawable.right_gray);
            }
        } else
        {
            //没有的话把图标隐藏了
            leftImg.setVisibility(View.INVISIBLE);
        }
//        这里设置左边的外边距以达到层级的效果
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) leftImg.getLayoutParams();
        params.setMargins(dip2px(contextx,12*(level + 1) - 8),0,0,0);
        leftImg.setLayoutParams(params);


        //该项被点击
        linearLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
//                HomeFragment.Companion.setMeDepartment_id(treeData.getDepartmentsID());
//                HomeFragment.Companion.searchPageUserSInfo(treeData.getDepartmentsID());

                if(!hasChild){
//                    TokenStatic.Companion.

//                    Toast.makeText(contextx,treeData.getDepartmentsID()+" ",Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(contextx, EmploymentLastActivity.class);
//                    intent.putExtra();
//                    contextx.startActivity(intent);

                }
//                frishAll(treeData);
//                如果该项展开就把他清出shrinkIdList,反之加进来

                if(shrinkIdList.contains(treeData.getCode()))
                {
                    shrinkIdList.remove(treeData.getCode());
                } else
                {

                    shrinkIdList.add(treeData.getCode());
                }
//                //处理一下新的List
                listProcessing();
                notifyDataSetChanged();
            }
        });
    }
    public void frishAll(final TreeData treeData){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://120.55.195.10:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ThingsService appService = retrofit.create(ThingsService.class);
//        appService.searchPage("1","200").enqueue(Object);
//        appService.pageUserSInfo(TokenStatic.Companion.getTOKEN(),1,10,treeData.getDepartmentsID()).enqueue(new Callback<PageUserSInfoResponse>() {
//            @Override
//            public void onResponse(Call<PageUserSInfoResponse> call, Response<PageUserSInfoResponse> response) {
//                PageUserSInfoResponse things1 = response.body();
//                if (things1 != null) {
//                    if(things1.getSuccess()){
////                        createPeople2();
//                        createPeople(things1.getData().getList(),1,0,level);
//                    }
//                    if(shrinkIdList.contains(treeData.getCode()))
//                    {
//                       frishPeople2();
//                        shrinkIdList.remove(treeData.getCode());
//                    } else
//                    {
////                        createPeople2();
////                        frishPeople2();
//                        shrinkIdList.add(treeData.getCode());
//                    }
//                    //处理一下新的List
//                    listProcessing();
//                    notifyDataSetChanged();
//                } else {
//                    Log.e("feifei2", "shibai");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<PageUserSInfoResponse> call, Throwable t) {
//                Log.e("feifei", t.getMessage());
//            }
//        });



    }

//     RecyclerView recyclerView;
     ArrayList treeData2=new ArrayList<TreeData>();

    TreeListPeopleAdapter treeListPeopleAdapter;
//

    public void frishPeople2(){
        TextRecyclerViewAdapter textRecyclerViewAdapter;
        ArrayList<String> arrayList=new ArrayList<>();

        textRecyclerViewAdapter= new TextRecyclerViewAdapter(arrayList);
//        recyclerView = findViewById<RecyclerView>(R.id.homeRecyclerView)
//        recyclerView.setLayoutManager(new LinearLayoutManager(contextx));
//        recyclerView.setAdapter(textRecyclerViewAdapter);
    }
     public void createPeople2(){
         Log.d("feifei", "createPeople2: 点击了一波 ");
         TextRecyclerViewAdapter textRecyclerViewAdapter;
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("feifei");
        arrayList.add("feifei");
        arrayList.add("feifei");
        arrayList.add("feifei");
        arrayList.add("feifei");
        arrayList.add("feifei");
        arrayList.add("feifei");


        textRecyclerViewAdapter= new TextRecyclerViewAdapter(arrayList);
//        recyclerView = findViewById<RecyclerView>(R.id.homeRecyclerView)
//        recyclerView.setLayoutManager(new LinearLayoutManager(contextx));
//        recyclerView.setAdapter(textRecyclerViewAdapter);
    }


    public void createPeople(List<PageUserSInfoResponseList> list, int code, int code_id, int level){
//        arrayList.add("feifei");
//        arrayList.add("feifei");
//        arrayList.add("feifei");
//        arrayList.add("feifei");
//        arrayList.add("feifei");
//        arrayList.add("feifei");
//        addAll( list,   code,   code_id, level);
        treeListPeopleAdapter= new TreeListPeopleAdapter(contextx,treeData2);
//        recyclerView = findViewById<RecyclerView>(R.id.homeRecyclerView)
//        recyclerView.setLayoutManager(new LinearLayoutManager(contextx));

//                .layoutManager = LinearLayoutManager(meContext)
//        treeListAdapter = TreeListAdapter(meContext, treeData)
//        recyclerView!!.adapter = treeListAdapter
//        recyclerView.setAdapter(treeListPeopleAdapter);
    }
    int codeMe=0;
//    public void addAll(List<PageUserSInfoResponseList> list,  int code,  int code_id,int level) {
//
//        for (PageUserSInfoResponseList department : list) {
//            Log.e(
//                    "feifeiSee",
//                    "department.name=${department.name}  codeMe=${codeMe} code_id=${code_id} level=${level}"
//            );
//            codeMe += 1;
//            treeData2.add(
//                    new TreeData(
//                            department.getName(),
//                            codeMe+"",
//                            code_id+"",
//                            level,
//                            false,
//                            (int) department.getId()
//                    )
//            );
//        }
//    }
    //这个方法用来处理列表显示的内容,先遍历所有列表，然后判断是否需要展开
    private void listProcessing()
    {
        int shrinkLevel ;
        ShownList.clear();
        for(int i=0;i<allList.size();i++)
        {
            TreeData treeData = allList.get(i);
            //如果发现遍历到的当前ID在shrinkIdList里面存在，说明需要展开直接把他加进要显示的列表即可
            if(shrinkIdList.contains(treeData.getCode()))
            {
                ShownList.add(treeData);
            } else
            {
                //否则先显示该项因为他是父级
                ShownList.add(treeData);
//                把当的层级拿出来
                shrinkLevel = treeData.getLevel();
                i++;
//                下面这个循环用来过滤掉那些折叠的项 把该区间的层级比当前大的过滤掉
                for(;i<allList.size();i++)
                {
//                    如果发现比当前大就跳出循环,否则执行下一个
                    if(allList.get(i).getLevel() > shrinkLevel)
                    {
                        continue;
                    } else
                    {
                        i--;
                        break;
                    }
                }
            }
        }
    }

    @Override
    public int getItemCount()
    {
        return ShownList.size();
    }

    //左边距设置用
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
