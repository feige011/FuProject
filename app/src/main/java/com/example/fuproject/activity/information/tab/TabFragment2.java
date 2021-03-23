package com.example.fuproject.activity.information.tab;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fuproject.R;
import com.example.fuproject.activity.information.anim.Anim;
import com.example.fuproject.activity.information.data.HistogramData;
import com.example.fuproject.activity.information.data.LineChartData;
import com.example.fuproject.activity.information.view.Histogram;
import com.example.fuproject.activity.information.view.LineChart;


public class TabFragment2 extends Fragment {
    float[] ydata = new float[7];
    float[] ydata2 = new float[7];
    int x2=0;
    String[] xdata;
    public static TabFragment2 newInstance(String label,int x) {

        Bundle args = new Bundle();
//        args.putString("label", label);
        TabFragment2 fragment = new TabFragment2(x);
        fragment.setArguments(args);
        return fragment;
    }
    public TabFragment2(int x2) {
        this.x2 = x2;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.chart, container, false);
        update1();
        xdata= new String[]{"2015","2016","2017","2018","2019","2020","2021"};
        Log.e("feifei","x2="+x2);
        switch (x2){
            case 1:{
                update1();
                break;
            }
            case 2:{
                update2();
                break;
            }
            case 4:{
                update4();
                break;
            }
            case 5:{
                update5();
                break;
            }
            case 6:{
                update6();
                break;
            }
        }

        final LineChart lineChart = (LineChart) root.findViewById(R.id.linechart);
        final LineChartData lineChartData = LineChartData.builder()
                .setXdata(xdata)
                .setYdata(ydata)
                .setCoordinatesColor(getResources().getColor(android.R.color.holo_orange_dark))
                .setYpCount(7)
                .setPointSize(20)
                .setAnimType(Anim.ANIM_ALPHA)
                .build();
        lineChart.setChartData(lineChartData);
        final Histogram histogramChart = (Histogram) root.findViewById(R.id.histogramchart);
        final HistogramData histogramData = HistogramData.builder()
                .setXdata(xdata)
                .setYdata(ydata)
                .setYpCount(7)
                .setAnimType(Anim.ANIM_ALPHA)
                .build();
        histogramChart.setChartData(histogramData);
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
    private void update1(){
        float d=5000f;
        for (int i=0;i<7;i++){
            d=d+(float) (Math.random() * 1000.0f-Math.random()*9f);
            ydata[i] = d;
            ydata2[i] = d;
        }
    }
    private void update2(){
        float d=50f;
        for (int i=0;i<7;i++){
            d=d+(float) (Math.random() * 10.0f-Math.random()*8f);
            ydata[i] = d;
            ydata2[i] = d;
        }
    }
    private void update6(){
        float d=100f;
        for (int i=0;i<7;i++){
            d=d+(float) (Math.random() * 30.0f-Math.random()*29f);
            ydata[i] = (int)d;
            ydata2[i] = (int)d;
        }
    }
    private void update4(){
        float d=20f;
        for (int i=0;i<7;i++){
            d=d+(float) (Math.random() * 15.0f-Math.random()*13f);
            ydata[i] = (int)d;
            ydata2[i] = (int)d;
        }
    }
    private void update5(){
        float d=15f;
        for (int i=0;i<7;i++){
            d=d+(float) (Math.random() * 15.0f-Math.random()*16f);
            ydata[i] = (int)d;
            ydata2[i] = (int)d;
        }
    }

}
