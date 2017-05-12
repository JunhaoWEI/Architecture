package com.example.weijunhao.architecture;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

public class MainActivity extends NetworkBasectivity implements View.OnClickListener {
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

    public void getWeather() {
        mObservable = RetroFactory.getInstance().weather_min("上海");
        mObservable.compose(mComposeFunction).subscribe(new BaseObserver<Weather>
                (MainActivity.this, mProgressDialog) {

            @Override
            void onHandleSuccess(Weather weather) {
                mTextView.setText(weather.getGanmao());
            }
        });
    }
}
