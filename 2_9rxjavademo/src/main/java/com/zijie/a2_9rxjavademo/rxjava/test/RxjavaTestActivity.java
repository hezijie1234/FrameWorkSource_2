package com.zijie.a2_9rxjavademo.rxjava.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zijie.a2_9rxjavademo.R;

public class RxjavaTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_test);
        findViewById(R.id.btn_net).setOnClickListener(v -> Log.e("111","test"));
    }
}
