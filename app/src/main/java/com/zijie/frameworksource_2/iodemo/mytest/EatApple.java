package com.zijie.frameworksource_2.iodemo.mytest;

/**
 * Created by hezijie on 2020/3/30.
 */
public class EatApple extends BigPerson {
    public EatApple(Person person) {
        super(person);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("吃苹果");
    }
}
