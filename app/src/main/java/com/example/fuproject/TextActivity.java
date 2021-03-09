//package com.example.fuproject;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Context;
//import android.os.Bundle;
//
//import com.example.fuproject.download.DownloadUtil;
//
//public class TextActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_text);
//        DownloadUtil.get().download(this, url,saveurl,fileName,  new DownloadUtil.OnDownloadListener() {
//            @Override
//            public void onDownloadSuccess() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(TeacherThesisCommentActivity.this, "下载成功", Toast.LENGTH_SHORT).show();
//                        // 这里的弹框设置了进度条，下同
//                        dialog.dismiss();
//
//                        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
//                            return;
//                        }
//
//                        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/download/"+fileName);
//                        Log.w(TAG,"路径2："+file);
//                        try {
//                            Log.w(TAG,"打开");
//                            OpenFileUtils.openFile(mContext, file);
//                        } catch (Exception e) {
//                            Log.w(TAG,"无打开方式");
//                            e.printStackTrace();
//                        }
//                    }
//                });
//            }
//
//            @Override
//            public void onDownloading(int progress) {
//                dialog.setProgress(progress);
//            }
//
//            @Override
//            public void onDownloadFailed() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(TeacherThesisCommentActivity.this, "下载失败", Toast.LENGTH_SHORT).show();
//                        dialog.dismiss();
//                    }
//                });
//            }
//        });
//    }
//    public static TextActivity getInstance() {
//        return sMyApp;
//    }
//
//    public ApplicationComponent getApplicationComponent() {
//        return mApplicationComponent;
//    }
//
//    public static Context getAppContext() {
//        return MyApp.context;
//    }
//
//}