package com.company.person;

import com.company.person.beans.Person;
import com.company.person.creators.PersonCreater;
import com.company.person.factories.PersonCreaterAbctractFactory;
import com.company.person.factories.PersonCreaterDBFactory;
import com.company.person.factories.PersonCreaterFileFactory;

/**
 * Created by alt-hanny on 24.07.2016.
 */
public class Main {
    public static void main(String[] args) {
//        PersonCreaterAbctractFactory createrDB = new PersonCreaterDBFactory();
//        PersonCreater personCreaterDB = createrDB.makePersonCreater();
//        Person personDB = personCreaterDB.readPerson();
//        System.out.println(personDB.getName() + " " + personDB.getAge());
//        personCreaterDB.writePerson(new Person(6, "Yauhen", 27));
//        personDB = personCreaterDB.readPerson("Hanna");
//        System.out.println(personDB.getName() + " " + personDB.getAge());
        System.out.println("******************************************");
        PersonCreaterAbctractFactory fileCreator = new PersonCreaterFileFactory();
        PersonCreater personCreaterFile = fileCreator.makePersonCreater();
        Person personCVS = personCreaterFile.readPerson();
        System.out.println(personCVS.getName() + " " + personCVS.getAge());
        personCreaterFile.writePerson(new Person(6,"Yauhen",32));
        personCVS = personCreaterFile.readPerson("Marina");
        if (personCVS.getName() != null) {
            System.out.println(personCVS.getName() + " " + personCVS.getAge());
        }


    }
}
