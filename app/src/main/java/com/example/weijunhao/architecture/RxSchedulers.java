package com.example.weijunhao.architecture;

import android.widget.Toast;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by WEI JUNHAO on 2017/5/12.
 */

public class RxSchedulers {
    public static <T> ObservableTransformer<T, T> compose() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(@NonNull Disposable disposable) throws Exception {
                                /*if (!NetworkUtil.isNetworkAvailable()) {
                                    Toast.makeText(. this, "网络连接异常，请检查网络", Toast.LENGTH_SHORT).
                                    show();
                                }*/
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
