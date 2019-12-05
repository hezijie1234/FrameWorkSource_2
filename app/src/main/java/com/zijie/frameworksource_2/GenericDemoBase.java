package com.zijie.frameworksource_2;

/**
 * Created by hezijie on 2019/11/20.
 * 泛型类的使用
 */
public class GenericDemoBase<T> {
    private T m;

    public GenericDemoBase() {
    }

    public GenericDemoBase(T m) {
        this.m = m;
    }

    public T getM() {
        return m;
    }

    public void setM(T m) {
        this.m = m;
    }
    public static void main(String args[]){
        GenericDemoBase<String> genericDemoBase = new GenericDemoBase<>();
        genericDemoBase.setM("子杰");
        System.out.println(genericDemoBase.getM());
    }
}
