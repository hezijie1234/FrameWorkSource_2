package com.zijie.frameworksource_2.iodemo.mytest;

/**
 * Created by hezijie on 2020/3/30.
 */
public class EatTomato extends BigPerson {
    public EatTomato(Person person) {
        super(person);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("吃西红柿");
    }
}
