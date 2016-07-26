package com.company.person.factories;

import com.company.person.creators.PersonCreatorI;
import com.company.person.creators.PersonCreatorFileImpl;

/**
 * Factory for the person creator for the work with file.
 * Created by alt-hanny on 25.07.2016.
 */
public class PersonCreatorFileFactory extends PersonCreatorAbctractFactory {
    /** Makes the person creator. File implementation. */
    public PersonCreatorI makePersonCreator() {
        return new PersonCreatorFileImpl();
    }
}
