package com.zijie.a2_7memory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hezijie on 2019/11/28.
 */
public class TestMemory {

    public static void main(String args[]){
        List<Object> data = new ArrayList<>();
        int i = 0;
        while (true){
            data.add(new Byte[1024 * 1024]);
            i++;
            if (i % 100 == 0){
                System.out.println(i);
            }
        }
    }
}
