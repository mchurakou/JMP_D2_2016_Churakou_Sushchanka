package com.company.person.creators;

import com.company.person.beans.Person;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by alt-hanny on 25.07.2016.
 */
public class PersonCreaterFile implements PersonCreater {
    private final String FILE_PATH = "module3\\factories\\resources\\person.csv";
    private static final String COMMA = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";


    public void writePerson(Person person) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true)){
            fileWriter.append(String.valueOf(person.getId()));
            fileWriter.append(COMMA);
            fileWriter.append(person.getName());
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(person.getAge()));
            fileWriter.append(NEW_LINE_SEPARATOR);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Person readPerson() {
        Person person = new Person();
        String cvsSplitBy = COMMA;
        File csvFile = new File(FILE_PATH);
        if (csvFile.exists()) {
            String line;
            try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
                while ((line = br.readLine()) != null) {
                    String[] personArr = line.split(cvsSplitBy);
                    person.setId(Integer.parseInt(personArr[0]));
                    person.setName(personArr[1]);
                    person.setAge(Integer.parseInt(personArr[2]));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return person;
    }

    public Person readPerson(String name) {
        Person person = new Person();
        String cvsSplitBy = COMMA;
        File csvFile = new File(FILE_PATH);
        if (csvFile.exists()) {
            String line;
            try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
                while ((line = br.readLine()) != null) {
                    String[] personArr = line.split(cvsSplitBy);
                    if (personArr[0].equals(name)){
                        person.setName(personArr[0]);
                        person.setAge(Integer.parseInt( personArr[1]));
                        return person;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return person;
    }
}
