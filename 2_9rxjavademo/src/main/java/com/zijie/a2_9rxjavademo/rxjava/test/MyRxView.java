package com.zijie.a2_9rxjavademo.rxjava.test;

import android.util.Log;
import android.view.View;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MyRxView {
    private static final String TAG = "MyRxView";

    //把按钮点击事件 转化成 Observable<>形式
    public static Observable<Object> clicks(View view){
        return new ViewClickObservable(view);
    }
}
