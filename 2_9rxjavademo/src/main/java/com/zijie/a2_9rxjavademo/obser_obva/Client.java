package com.zijie.a2_9rxjavademo.obser_obva;

/**
 * Created by hezijie on 2019/12/5.
 */
public class Client {

    public static void main(String args[]){
        Observable observable = new WechatServer();
        Observer observer = new User("zijie");
        Observer observer2 = new User("zijie2");
        Observer observer3 = new User("zijie3");
        observable.add(observer);
        observable.add(observer2);
        observable.add(observer3);
        ((WechatServer) observable).pushMsg("你是一个好人！");

    }
}
