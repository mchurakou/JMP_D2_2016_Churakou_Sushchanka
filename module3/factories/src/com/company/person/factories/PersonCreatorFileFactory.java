package com.company.person.factories;

import com.company.person.creators.PersonCreatorI;
import com.company.person.creators.PersonCreatorFile;

/**
 * Created by alt-hanny on 25.07.2016.
 */
public class PersonCreatorFileFactory extends PersonCreatorAbctractFactory {
    public PersonCreatorI makePersonCreator() {
        return new PersonCreatorFile();
    }
}
