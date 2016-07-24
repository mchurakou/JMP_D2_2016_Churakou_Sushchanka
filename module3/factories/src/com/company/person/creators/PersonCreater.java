package com.company.person.creators;

import com.company.person.beans.Person;

/**
 * Created by alt-hanny on 24.07.2016.
 */
public interface PersonCreater {
    void writePerson(Person person);
    Person readPerson();
    Person readPerson(String name);
}
