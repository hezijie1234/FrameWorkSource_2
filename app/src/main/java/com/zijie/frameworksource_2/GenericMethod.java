package com.zijie.frameworksource_2;

/**
 * Created by hezijie on 2019/11/20.
 */
public class GenericMethod<T> {

    public <T> T sum(T ... t){
        return t[t.length / 2];
    }

    //类必须要放在最前面，且只能有一个类，接口写在最后面
    public <T extends Object&Comparable ,K> boolean min(T t1,T t2){
        if (t1.compareTo(t2) > 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        GenericMethod<String> genericMethod = new GenericMethod<>();
        int sum = genericMethod.sum(1, 2, 3, 4);
        System.out.println(sum);
        System.out.println(genericMethod.sum("he","zi","jie","liu"));

        System.out.println(genericMethod.min(3,2));

        System.out.println(new GenericMethod<String>().getClass() + "---" + new GenericMethod<Double>().getClass());
    }
}
