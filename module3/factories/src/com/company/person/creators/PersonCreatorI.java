package com.company.person.creators;

import com.company.person.beans.Person;

import java.io.IOException;

/**
 * Person creators interface.
 */
public interface PersonCreatorI {
    /** Writes the person. */
    void writePerson(Person person) throws IOException;
    /** Reads the person. */
    Person readPerson() throws IOException, ClassNotFoundException;
    /** Reads the person by name. */
    Person readPerson(String name);
}
