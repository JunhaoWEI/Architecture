package com.example.rxjavaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String BASE_UEL = "http://wthrcdn.etouch.cn/";
    private TextView mTextView;
    private Button mButton;

    private Observable mObservable;
    private Object mWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textview);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                getWeather();
                break;
            default:
                break;
        }
    }

    private void getWeather() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.d("wjh", message);
                    }
                }).setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_UEL)
                .client(client)
                .build();
        MyService service = retrofit.create(MyService.class);

        service.weather_mini("上海")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity<Weather>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        // Log.d("wjh", "onSubscribe: ");
                    }

                    @Override
                    public void onNext(@NonNull BaseEntity<Weather> weatherBaseEntity) {
                        mTextView.setText(weatherBaseEntity.getData().getGanmao());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        // Log.d("wjh", "onError: ");

                    }

                    @Override
                    public void onComplete() {
                        //  Log.d("wjh", "onComplete: ");
                    }
                });
    }
}
