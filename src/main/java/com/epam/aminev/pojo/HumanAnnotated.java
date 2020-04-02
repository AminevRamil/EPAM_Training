package com.epam.aminev.pojo;

import com.epam.aminev.annotations.Entity;
import com.epam.aminev.annotations.Value;

@Entity
public class HumanAnnotated {
    @Value()
    private int age;

    @Value()
    private String name;

    public HumanAnnotated(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public HumanAnnotated(){

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
