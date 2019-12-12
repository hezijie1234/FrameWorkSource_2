package com.zijie.a2_9rxjavademo.rxjava.test;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.zijie.a2_9rxjavademo.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RetrofitRxjavaActivity extends AppCompatActivity {
    private static final String TAG = "111";
    Disposable disposable;
    private Observable<Boolean> booleanObservable;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_rxjava);
        WanAndroidApi wanAndroidApi = HttpUtil.getOnlineCookieRetrofit().create(WanAndroidApi.class);
        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                wanAndroidApi.getProject()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ProjectBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(ProjectBean projectBean) {
                                Log.e("111", projectBean.toString());
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });
        //rxjava原有的功能防抖
        Disposable disposable = RxView.clicks(findViewById(R.id.btn_2))
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object v) throws Exception {
                        Log.e("111", "点击了" + Thread.currentThread().getName());
                    }
                });

        //自定义将点击事件处理成被观察者发送的信号
//        Disposable disposable1 = MyRxView.clicks(findViewById(R.id.btn_2))
//                .throttleFirst(2, TimeUnit.SECONDS)
//                .subscribe(new Consumer<Object>() {
//                    @Override
//                    public void accept(Object v) throws Exception {
//                        Log.e("111", "点击了" + Thread.currentThread().getName());
//                    }
//                });

        EditText etPhone = findViewById(R.id.et_phone);
        EditText etPassword = findViewById(R.id.et_password);
        EditText etVerify = findViewById(R.id.et_verify);
        Button btnLogin = findViewById(R.id.btn_login);
        Observable<CharSequence> phoneObservable = RxTextView.textChanges(etPhone);
        Observable<CharSequence> passwordObservable = RxTextView.textChanges(etPassword);
        Observable<CharSequence> verifyObservable = RxTextView.textChanges(etVerify);
        List<Observable<CharSequence>> list = new ArrayList<>();
        list.add(phoneObservable);
        list.add(passwordObservable);
        list.add(verifyObservable);
        //联合控制满足条件按钮才可以点击。
//        Observable.combineLatest(phoneObservable, passwordObservable, new BiFunction<CharSequence, CharSequence, Boolean>() {
//            @Override
//            public Boolean apply(CharSequence phone, CharSequence password) throws Exception {
//                if (phone.toString().length() == 11 && password.toString().length() == 6){
//                    return true;
//                }
//                return false;
//            }
//        }).subscribe(new Consumer<Boolean>() {
//            @Override
//            public void accept(Boolean aBoolean) throws Exception {
//                btnLogin.setEnabled(aBoolean);
//            }
//        });
        Iterator<Observable<CharSequence>> iterator = list.iterator();
        //数据很多时
        Observable.combineLatest(list, new Function<Object[], Boolean>() {
            @Override
            public Boolean apply(Object[] objects) throws Exception {
                if (objects.length == 3) {
                    if (objects[0].toString().length() == 11 && objects[1].toString().length() == 6 && objects[2].toString().length() == 4) {
                        return true;
                    }
                }
                return false;
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                btnLogin.setEnabled(aBoolean);
            }
        });

        RxView.clicks(btnLogin)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        Toast.makeText(RetrofitRxjavaActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                    }
                });


        //用rxjava实现验证码倒计时,需要设置第1次延迟时间为0；
        Button btnVerify = findViewById(R.id.btn_verify);
        booleanObservable = RxView.clicks(btnVerify)
                .throttleFirst(60, TimeUnit.SECONDS)
                .map(new Function<Object, Boolean>() {
                    @Override
                    public Boolean apply(Object o) throws Exception {
                        Log.e(TAG, "apply: map操作执行了");
                        return false;
                    }
                }).doOnNext(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Log.e("111", "accept: " + aBoolean);
                        btnVerify.setEnabled(aBoolean);
                    }
                });

        booleanObservable.subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                Observable
                        .interval(0,1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                        .take(60)
                        .subscribe(new Observer<Long>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Long aLong) {
                                try {
                                    RxTextView.text(btnVerify).accept("剩余" + (60 - aLong) + "秒");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                            }

                            @Override
                            public void onComplete() {
                                try {
                                    RxTextView.text(btnVerify).accept("获取验证码");
                                    RxView.enabled(btnVerify).accept(true);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != booleanObservable)
        booleanObservable.unsubscribeOn(AndroidSchedulers.mainThread());
    }

    private boolean isPhoneValid(String phone) {
        return phone.length() == 11;
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 6;
    }

}
