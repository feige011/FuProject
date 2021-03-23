package com.example.fuproject.activity.information.tab;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fuproject.R;
import com.example.fuproject.activity.information.data.PieChartData;
import com.example.fuproject.activity.information.view.PieChart;


public class TabFragment3 extends Fragment {
    float[] datas = new float[9];
    public static TabFragment3 newInstance(String label) {

        Bundle args = new Bundle();
//        args.putString("label", label);
        TabFragment3 fragment = new TabFragment3();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.piechart, container, false);
        update();
        final PieChart pieChart = (PieChart) root.findViewById(R.id.piechart);
        final int[] colors = new int[]{Color.RED,Color.BLACK,Color.BLUE,Color.GREEN,Color.GRAY,
                Color.YELLOW,Color.LTGRAY,Color.CYAN,Color.MAGENTA};
        final PieChartData pieChartData = PieChartData.builder()
                .setDatas(datas)
                .setColors(colors)
//                .setTextColor(Color.RED)
//                .setTextSize(36)
//                .setSeparationDegree(3)
                .build();
        pieChart.setChartData(pieChartData);

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
//        setContentView(R.layout.chart);


//        update();
//        xdata= new String[]{"2015","2016","2017","2018","2019","2020","2021"};
//        if(x2<=3){
//            xdata=new  String[]{"feige011","feige012","feige013","feige014","feige015","feige016","feige017"};
//
//        }
//        final LineChart lineChart = (LineChart) getView().findViewById(R.id.linechart);
//        final LineChartData lineChartData = LineChartData.builder()
//                .setXdata(xdata)
//                .setYdata(ydata)
//                .setCoordinatesColor(getResources().getColor(android.R.color.holo_orange_dark))
//                .setYpCount(7)
//                .setPointSize(20)
//                .setAnimType(Anim.ANIM_ALPHA)
//                .build();
//        lineChart.setChartData(lineChartData);
//        final Histogram histogramChart = (Histogram) getView().findViewById(R.id.histogramchart);
//        final HistogramData histogramData = HistogramData.builder()
//                .setXdata(xdata)
//                .setYdata(ydata)
//                .setYpCount(7)
//                .setAnimType(Anim.ANIM_ALPHA)
//                .build();
//        histogramChart.setChartData(histogramData);
        
        
//        getView().findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                update();
//                lineChartData.setYdata(ydata);
//                histogramData.setYdata(ydata2);
//                lineChart.update(lineChartData);
//                histogramChart.update(histogramData);
//            }
//        });
//        String label = getArguments().getString("label");
//        TextView text = getView().findViewById(R.id.tv_bg);
//        text.setText(label);
//        text.setBackgroundColor(Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
    }
    private void update(){
        for (int i=0;i<9;i++){
            datas[i] = (float) (Math.random() * 50.0f);
        }
    }
}
