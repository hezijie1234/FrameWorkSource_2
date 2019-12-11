package com.zijie.a2_9rxjavademo.obser_obva;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hezijie on 2019/12/5.
 */
public class WechatServer implements Observable {
    private List<Observer> observers = new ArrayList<>();

    public void pushMsg(String msg){
        for (Observer observer : observers){
            observer.getMsg(msg);
        }
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void update() {

    }
}
