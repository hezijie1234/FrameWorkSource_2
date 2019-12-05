package com.zijie.frameworksource_2.refle.zijie;

/**
 * Created by hezijie on 2019/11/25.
 */
public class Student {

    private int age;
    public String name;

    private int hegiht;

    public Student() {
    }



    public Student(int age, String name, int hegiht) {
        this.age = age;
        this.name = name;
        this.hegiht = hegiht;
    }

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHegiht() {
        return hegiht;
    }

    public void setHegiht(int hegiht) {
        this.hegiht = hegiht;
    }
}
