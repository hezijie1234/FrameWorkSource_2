package com.zijie.frameworksource_2.refle.zijie;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by hezijie on 2019/11/25.
 */
public class TestReflect {

    public static void main(String [] args) throws Exception {
        Class<Student> studentClass = Student.class;
        Class<Student> aClass = (Class<Student>) Class.forName("com.zijie.frameworksource_2.refle.zijie.Student");
        Student student = new Student();
        Class<Student> aClass1 = (Class<Student>)student.getClass();


        //测试类的构造器
//        testConstructor();
        //测试成员变量
        testField();
    }

    private static void testConstructor() throws Exception {
        Class<Student> studentClass = Student.class;

        Constructor<Student>[] constructors = (Constructor<Student>[]) studentClass.getConstructors();
        for (Constructor<Student> constructor: constructors){
            System.out.println(constructor);
        }
        Constructor<Student> constructor = studentClass.getConstructor(int.class, String.class, int.class);
        Student student = constructor.newInstance(18, "zijie", 178);
        System.out.println(student.getName());
        Method[] methods = studentClass.getMethods();
        for (Method method :
                methods) {
            System.out.println(method);
        }
        Method setName = studentClass.getMethod("setName", String.class);
        setName.invoke(student,"hezijie");
        System.out.println(student.getName());
        Method setAge = studentClass.getDeclaredMethod("setAge", int.class);
        setAge.setAccessible(true);
        setAge.invoke(student,22);
        Method getAge = studentClass.getDeclaredMethod("getAge");
        getAge.setAccessible(true);
        Integer age = (Integer) getAge.invoke(student);
        System.out.println(age);
    }

    private static void testField() throws Exception {
        Class<Student> studentClass = Student.class;
        Student student = studentClass.newInstance();
        Field[] fields = studentClass.getDeclaredFields();
        for (Field field:
             fields) {
            System.out.println(field);
        }
        Field age = studentClass.getDeclaredField("age");
        age.setAccessible(true);
        System.out.println(age.get(student));
        age.set(student,18);
        Method getAge = studentClass.getDeclaredMethod("getAge");
        getAge.setAccessible(true);

        System.out.println(age.get(student));
    }
}
