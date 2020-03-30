package com.zijie.frameworksource_2.iodemo.mytest;

/**
 * Created by hezijie on 2020/3/30.
 */
public class MyPerson extends Person {

    public MyPerson() {
    }

    public MyPerson(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("我自己想吃什么就吃什么");
    }
}
