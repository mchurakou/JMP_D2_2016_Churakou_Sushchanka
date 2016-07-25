package com.company.person.beans;

import java.io.Serializable;

/**
 * Created by alt-hanny on 24.07.2016.
 */
public class Person implements Serializable {

    private final static long serialVersionUID = 201624072222L;
    private long id;
    private String name;
    private int age;

    public Person() {
    }

    public Person(long id, String name, int age) {
        this.id = id;
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

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(id);
        result.append(name);
        result.append(age);
        return result.toString();
    }
}
