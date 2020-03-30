package com.zijie.a2_9rxjavademo.annotation;

/**
 * Created by hezijie on 2019/12/13.
 */

public class Student extends Human{

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String ... args){
        Student student = new Student("hezijie",18);
        Class<Student> studentClass = Student.class;
        if (studentClass.isAnnotationPresent(AnoTest.class)){
            AnoTest annotation = studentClass.getAnnotation(AnoTest.class);
            System.out.println(annotation.num() + annotation.type());
        }
    }
}
