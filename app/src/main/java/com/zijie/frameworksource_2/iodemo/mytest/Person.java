package com.zijie.frameworksource_2.iodemo.mytest;

/**
 * Created by hezijie on 2020/3/30.
 */
public abstract class Person {
    private String name;
    public Person(String name) {
        // TODO Auto-generated constructor stub
        this.name = name;
    }
    public Person() {
    }

    public abstract void eat();
}
