package com.example.fuproject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.os.Environment;
/**
 * 访问sdcard的工具函数
 * */
public class FileUtils {

    private String SDPATH;

    public String getSDPATH() {
        return SDPATH;
    }
    public void setSDPATH(String sdpath) {
        SDPATH = sdpath;
    }
    public FileUtils() {
        // 得到当前外部存储设备的目录,即: /SDCARD
        SDPATH = Environment.getExternalStorageDirectory() + "/";
    }
    /**
     * 在SD卡上创建文件
     *
     */
    public File creatSDFile(String fileName) throws IOException {
        File file = new File(SDPATH + fileName);
        file.createNewFile();
        return file;
    }

    /**
     * 在SD卡上创建目录
     */
    public File createDir(String dirName) {
        File dir = new File(SDPATH + dirName);
        dir.mkdir();
        return dir;
    }

    /**
     * 判断SD卡上的文件夹是否存在
     */
    public boolean isFileExist(String fileName) {
        File file = new File(SDPATH + fileName);
        return file.exists();
    }

    /**
     * 将一个InputStream 里面的数据写入到SD卡中
     */
    public File write2SDFromInput(String path, String fileName,
                                  InputStream input) {
        File file = null;
        OutputStream output = null;

        try {
            createDir(path);//创建目录
            File f = creatSDFile(path + fileName);//创建文件
            output = new FileOutputStream(f);
            byte buffer[] = new byte[4 * 1024];
            while ((input.read(buffer)) != -1) {
                output.write(buffer);
            }
            System.out.println(path);
            file = new File(path);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}