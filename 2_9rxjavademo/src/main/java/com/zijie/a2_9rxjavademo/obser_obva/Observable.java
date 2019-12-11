package com.zijie.a2_9rxjavademo.obser_obva;

/**
 * Created by hezijie on 2019/12/5.
 */
public interface Observable {

    void add(Observer observer);
    void remove(Observer observer);

    void update();
}
