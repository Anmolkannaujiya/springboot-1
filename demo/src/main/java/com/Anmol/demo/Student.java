package com.Anmol.demo;

import org.springframework.stereotype.Component;


@Component

public class Student {
    private String name;
    private int age;

    public Student(){
        System.out.println("Heloo");
    }

    public Student(int age,String name){
        this();
        this.age = age;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
