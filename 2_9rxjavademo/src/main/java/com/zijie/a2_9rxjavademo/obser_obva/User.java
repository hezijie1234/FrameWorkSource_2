package com.zijie.a2_9rxjavademo.obser_obva;

/**
 * Created by hezijie on 2019/12/5.
 */
public class User implements Observer {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void getMsg(Object obj) {
        System.out.println(name + obj);
    }
}
