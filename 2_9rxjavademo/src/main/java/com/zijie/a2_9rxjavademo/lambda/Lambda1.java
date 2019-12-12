package com.zijie.a2_9rxjavademo.lambda;

/**
 * Created by hezijie on 2019/12/12.
 */
public class Lambda1 {

    public  static void main(String[] args){
        MyOnClick my = () -> System.out.println("何子杰");
        my.onClick();

    }

    interface MyOnClick{
        void onClick();
    }

    interface MyOnClick2{
        String onClick();
    }
}
