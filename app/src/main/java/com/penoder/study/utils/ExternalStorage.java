package com.penoder.study.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by dell on 2017/9/12.
 */
public class ExternalStorage {

    /**
     * Checks if external storage is available for read and write
     */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if external storage is available to at least read
     */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    // public External Storage
    public File getAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.  参数有 DIRECTORY_MUSIC 或 DIRECTORY_PICTURES 等
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.i("TAG", "Directory not created");
        }
        return file;
    }

    // private External Storage
    public File getAlbumStorageDir(Context context, String albumName) {
        // Get the directory for the app's private pictures directory.  // 可用的参数比上面 public 存储的要多
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), albumName);   // albumName 传递 null，将返回 private 存储的根目录
        if (!file.mkdirs()) {
            Log.i("TAG", "Directory not created");
        }
        return file;
    }
}
