package com.epam.aminev.pojo;

/**
 * The {@code Human} class represents POJO entity without annotations
 *
 * @author Aminev Ramil
 */
public class Human {
    int age;
    String name;

    /**
     * Construct new instance with specified fields values
     * @param age
     * @param name
     */
    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Human(){

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
