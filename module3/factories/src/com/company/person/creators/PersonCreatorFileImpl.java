package com.company.person.creators;

import com.company.person.beans.Person;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

/**
 * Implements person creator. Work with file.
 */
public class PersonCreatorFileImpl implements PersonCreatorI {
    /** Tha file path constant. */
    private final static String FILE_PATH = "module3\\factories\\resources\\person.csv";

    /**
     * Writes the person to file.
     * @param person
     */
    public void writePerson(Person person) {
        File file = new File(FILE_PATH);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(person);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the person from file.
     * @return Person.
     */
    public Person readPerson() {
        Person person = new Person();
        File csvFile = new File(FILE_PATH);
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(csvFile))){
            person = (Person) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return person;
    }

    /**
     * Reads the person from file by name.
     * @param name Person's name.
     * @return Person.
     */
    public Person readPerson(String name) {
        Person person;
        File csvFile = new File(FILE_PATH);
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(csvFile))){
            person = (Person) ois.readObject();
            if (person.getName().equals(name)) {
                return person;
            }
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return new Person();
    }
}
