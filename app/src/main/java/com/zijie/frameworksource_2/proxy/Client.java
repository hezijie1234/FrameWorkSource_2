package com.zijie.frameworksource_2.proxy;


import com.zijie.frameworksource_2.proxy.dynamic.MarkCompany;
import com.zijie.frameworksource_2.proxy.normal.Alvin;
import com.zijie.frameworksource_2.proxy.normal.Mark;

import java.lang.reflect.Method;

/**
 *@author Mark老师   享学课堂 https://enjoy.ke.qq.com 
 *
 *往期课程咨询芊芊老师  QQ：2130753077 VIP课程咨询 依娜老师  QQ：2470523467
 *
 *类说明：张三
 */
public class Client {

    public static void main(String[] args) {
        /*静态代理模式---------------*/
        ManToolsFactory factory = new AaFactory();
        Mark mark = new Mark(factory);
        mark.saleManTools("D");
//
        WomanToolsFactory womanToolsFactory = new BbFactory();
        Alvin av = new Alvin(womanToolsFactory);
        av.saleWomanTools(1.8f);

        /*动态代理模式---------------*/
        ManToolsFactory aafactory = new AaFactory();
        MarkCompany markCompany = new MarkCompany();
        markCompany.setFactory(aafactory);

        //张三来了
        ManToolsFactory employee1
                = (ManToolsFactory)markCompany.getProxyInstance();
        employee1.saleManTools("E");

        //张三老婆来了
        WomanToolsFactory bbToolsFactory = new BbFactory();
        markCompany.setFactory(bbToolsFactory);
        WomanToolsFactory employee2
                = (WomanToolsFactory)markCompany.getProxyInstance();
        employee2.saleWomanTools(1.9f);


//        ProxyUtils.generateClassFile(aafactory.getClass(),
//                employee1.getClass().getSimpleName());
//        ProxyUtils.generateClassFile(bbToolsFactory.getClass(),
//                employee2.getClass().getSimpleName());
//        Method[] methods = aafactory.getClass().getMethods();
//        for(Method method:methods) {
//            System.out.println(method.getName());//打印方法名称
//        }
        System.out.println(java.nio.charset.Charset.defaultCharset().toString());
        System.out.println("学java".getBytes().length);//打印方法名称
    }

}
