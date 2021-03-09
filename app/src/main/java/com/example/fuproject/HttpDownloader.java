package com.example.fuproject;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDownloader {

    private URL url = null;

    /**
     * 根据URL下载文件，前提是这个文件中的内容是文本，函数的返回值就是文件的内容
     * 1.创建一个URL对象
     * 2.通过URL对象，创建一个HttpURLConnection对象
     * 3.得到InputStream
     * 4.从InputStream中读取数据
     */
    public String download(String urlStr) {
        StringBuffer sb = new StringBuffer();
        String line = null;
        BufferedReader buffer = null;
        try {
            // 创建一个URL对象
            Log.e("feifei0","0");
            url = new URL(urlStr);
            Log.e("feifei1","1");
            // 创建一个Http连接
            HttpURLConnection urlConn = (HttpURLConnection) url
                    .openConnection();
            Log.e("feifei2","2");
            buffer = new BufferedReader(new InputStreamReader(urlConn
                    .getInputStream()));
            // 使用IO流读取数据
            Log.e("feifei3","3");
            while ((line = buffer.readLine()) != null) {
                sb.append(line);
            }
            Log.e("feifei4","4");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            try {
//                buffer.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        return sb.toString();
    }

    /**
     * 将下载的mp3文件写到sdcard
     *
     * 该函数放回整型-1：代表下载文件出错 0：代表下载文件成功 1：代表文件已经存在
     */

    public int downFile(String urlStr, String path, String fileName) {
        InputStream inputStream = null;
        try {
            FileUtils fileUtils = new FileUtils();

            if (fileUtils.isFileExist(path + fileName)) {
                return 1;
            } else {
                inputStream = getInputStreamFromUrl(urlStr);

                File resultFile = fileUtils.write2SDFromInput(path, fileName,
                        inputStream);

                if (resultFile == null) {
                    return -1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return 0;
    }

    private InputStream getInputStreamFromUrl(String urlStr) throws IOException {
        url = new URL(urlStr);
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
        InputStream inputStream = urlConn.getInputStream();
        return inputStream;
    }

}