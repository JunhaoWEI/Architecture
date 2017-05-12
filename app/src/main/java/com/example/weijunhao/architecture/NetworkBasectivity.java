package com.example.weijunhao.architecture;

import android.app.ProgressDialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class NetworkBasectivity extends AppCompatActivity {
    private static final long RETRY_TIMES = 1;
    public ProgressDialog mProgressDialog;
    private boolean showLoading = true;
    public ObservableTransformer<Observable, ObservableSource> mComposeFunction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_network_basectivity);

        init();
    }

    private void init() {
        mProgressDialog = new ProgressDialog(this);

        mComposeFunction = new ObservableTransformer() {
            @Override
            public ObservableSource apply(@NonNull Observable upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(@NonNull Disposable disposable) throws Exception {
                                if (!NetworkUtil.isNetworkAvailable(NetworkBasectivity.this)) {
                                    Toast.makeText(NetworkBasectivity.this, "网络连接异常，请检查网络", Toast.LENGTH_SHORT).
                                            show();
                                }
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public void setLoadingFlag(boolean show) {
        showLoading = show;
    }

    @Override
    protected void onStop() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
        super.onStop();
    }
}


