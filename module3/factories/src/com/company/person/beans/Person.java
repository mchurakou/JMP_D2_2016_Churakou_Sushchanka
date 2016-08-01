package com.company.person.beans;

import java.io.Serializable;

/**
 * Person bean.
 */
public class Person implements Serializable {

    private final static long serialVersionUID = 201624072222L;
    /** Person's ID. */
    private long id;
    /** Person's name. */
    private String name;
    /** Person's age. */
    private int age;

    /**
     * Default constructor.
     */
    public Person() {
    }

    /**
     * Constructor with parameters.
     * @param id Person's ID.
     * @param name Person's name.
     * @param age Person's age.
     */
    public Person(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * Gets the name of the person.
     * @return Person's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the person's name.
     * @param name Person's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age of the person.
     * @return Person's age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the person's age.
     * @param age Person's age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the ID of the person.
     * @return Person's id.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the person's id.
     * @param id Person's id.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Presents object as string.
     * @return String of the person.
     */
    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(id);
        result.append(name);
        result.append(age);
        return result.toString();
    }
}
