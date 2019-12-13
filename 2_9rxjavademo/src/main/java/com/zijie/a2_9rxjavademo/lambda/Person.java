package com.zijie.a2_9rxjavademo.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hezijie on 2019/12/13.
 */
public class Person {

    private int age;
    private int score;
    private String name;
    private Integer height;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Person(int age, int score, String name, Integer height) {
        this.age = age;
        this.score = score;
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", score=" + score +
                ", name='" + name + '\'' +
                '}';
    }

    public Person() {
    }

    public Person(int age, int score, String name) {
        this.age = age;
        this.score = score;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static void main(String ... args){
        Person person = new Person(20,90,"hezijie",177);
        Person person2 = new Person(19,80,"wang",179);
        Person person3 = new Person(21,85,"li",175);
        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person2);
        list.add(person3);
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {

                return o1.getAge() - o2.getAge();
            }
        });
//        Collections.sort(list,Comparator.comparing(Person::getHeight));
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        System.out.println("对分数进行排序后");
        Collections.sort(list,(o1, o2) -> o1.getScore() - o2.getScore());
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}
