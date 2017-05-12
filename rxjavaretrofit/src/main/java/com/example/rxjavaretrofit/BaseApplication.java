package com.example.rxjavaretrofit;

import android.app.Application;
import android.content.pm.ApplicationInfo;

/**
 * Created by WEI JUNHAO on 2017/5/12.
 */

public class BaseApplication extends Application {
    public static String baseUrl = "http://wthrcdn.etouch.cn/";

    public static boolean isDebug() {
        return true;
    }
}
