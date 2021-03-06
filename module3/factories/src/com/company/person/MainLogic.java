package com.company.person;

import com.company.person.beans.Person;
import com.company.person.creators.HeandlerI;

import java.io.IOException;

/**
 * Main logic. Reading and writing persons.
 * Created by alt-hanny on 24.07.2016.
 */
class MainLogic {
    static void execute(HeandlerI personCreator) throws IOException, ClassNotFoundException {
        personCreator.writePerson(new Person(2, "Hanna", 27));
        Person person = personCreator.readPerson();
        System.out.println("Reading" + person);
        person = personCreator.readPerson("Hanna");
        System.out.println(person.getName() + " " + person.getAge());
        System.out.println("Reading the last added person in the file: " + person.getName() + " " + person.getAge());
        if (person.getName() != null) {
            System.out.println("Reading person by name: " + person.getName() + " " + person.getAge());
        } else {
            System.out.println("The person not found.");
        }
    }
}
