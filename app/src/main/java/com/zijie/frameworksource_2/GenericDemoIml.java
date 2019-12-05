package com.zijie.frameworksource_2;

/**
 * Created by hezijie on 2019/11/20.
 * 实现了泛型的接口但是不指明泛型的类型，也可以指明泛型的类型
 */
public class GenericDemoIml<T> implements GenericDemoInterface<String> {


    @Override
    public String getData() {
        return null;
    }
}
