package com.zijie.frameworksource_2.iodemo.mytest;

/**
 * Created by hezijie on 2020/3/30.
 */
public  class BigPerson extends Person{

    private Person person;

    public BigPerson(Person person) {
        this.person = person;
    }


    @Override
    public void eat() {
        person.eat();
    }
}
