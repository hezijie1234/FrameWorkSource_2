package com.zijie.a2_7memory;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by hezijie on 2019/11/28.
 */
public class TestMemory extends Handler implements View.OnClickListener, AdapterView.OnItemClickListener {

    public static void main(String args[]){
        TestMemory testMemory = new TestMemory();
        Type genericSuperclass = TestMemory.class.getGenericSuperclass();
        System.out.println(genericSuperclass);
//        List<Object> data = new ArrayList<>();
//        int i = 0;
//        while (true){
//            data.add(new Byte[1024 * 1024]);
//            i++;
//            if (i % 100 == 0){
//                System.out.println(i);
//            }
//        }
    }



    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void publish(LogRecord record) {

    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}
