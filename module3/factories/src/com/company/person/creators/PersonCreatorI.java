package com.company.person.creators;

import com.company.person.beans.Person;

import java.io.IOException;

/**
 * Created by alt-hanny on 24.07.2016.
 */
public interface PersonCreatorI {
    void writePerson(Person person) throws IOException;
    Person readPerson() throws IOException, ClassNotFoundException;
    Person readPerson(String name);
}
