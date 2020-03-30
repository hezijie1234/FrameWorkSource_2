package com.zijie.frameworksource_2.iodemo.mytest;

/**
 * Created by hezijie on 2020/3/30.
 */
public class TestMyDemo {

    public static void main(String [] args){
        MyPerson myPerson = new MyPerson("zijie");
        EatApple eatApple = new EatApple(myPerson);
        EatTomato eatTomato = new EatTomato(eatApple);
        eatTomato.eat();
    }
}
