package com.example.weijunhao.architecture;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;


import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by WEI JUNHAO on 2017/5/12.
 */

public abstract class BaseObserver<T> implements Observer<BaseEntity<T>> {
    private Context mContext;
    private ProgressDialog mProgressDialog;
    private Disposable mDisposable;
    private final int SUCCESS_CODE = 1000;

    public BaseObserver(Context context, ProgressDialog progressDialog) {
        mContext = context;
        mProgressDialog = progressDialog;
        Log.d("wjh", "BaseObserver: ");
        mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                mDisposable.dispose();
            }
        });
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        mDisposable = d;
    }

    @Override
    public void onNext(@NonNull BaseEntity<T> tBaseEntity) {
        if (tBaseEntity.getStatus() == SUCCESS_CODE) {
            T t = tBaseEntity.getData();
            onHandleSuccess(t);
        } else {
            onHandlerError(tBaseEntity.getStatus(), tBaseEntity.getDesc());
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onComplete() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    abstract void onHandleSuccess(T t);

    void onHandlerError(int status, String desc) {
        Toast.makeText(mContext, desc, Toast.LENGTH_SHORT).show();
    }
}
