package com.example.rxjavaretrofit;

import android.content.Context;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by WEI JUNHAO on 2017/5/12.
 */

public class RetrofitManager {

    public static Retrofit getInstance() {
        return Instance.retrofit;
    }

    private static class Instance {
        private static String baseUrl = BaseApplication.baseUrl;
        private static Retrofit retrofit = getRetrofit();

        private static Retrofit getRetrofit() {
            OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
            if (BaseApplication.isDebug()) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(
                        new HttpLoggingInterceptor.Logger() {
                            @Override
                            public void log(String message) {
                                Log.d("wjh", message);
                            }
                        }).setLevel(HttpLoggingInterceptor.Level.BODY);
                okHttpBuilder.addInterceptor(interceptor);
            }
            /*//获取自定义Application中返回的公共请求头
            okHttpBuilder.addInterceptor(new HeaderInterceptor());
            //获取自定义Application中返回的公共请求参数
            okHttpBuilder.addInterceptor(new ParamsInterceptor());*/

            //设置网络连接失败时自动重试
            okHttpBuilder.retryOnConnectionFailure(true);
            //设置连接超时
            okHttpBuilder.connectTimeout(5, TimeUnit.SECONDS);
            //设置写超时
            okHttpBuilder.writeTimeout(10, TimeUnit.SECONDS);
            //设置读超时
            okHttpBuilder.readTimeout(10, TimeUnit.SECONDS);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            return retrofit;
        }

    }

}

