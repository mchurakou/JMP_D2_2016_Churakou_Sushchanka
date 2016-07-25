package com.company.person.factories;

import com.company.person.creators.PersonCreatorI;
import com.company.person.creators.PersonCreatorDB;

/**
 * Created by alt-hanny on 25.07.2016.
 */
public class PersonCreatorDBFactory extends PersonCreatorAbctractFactory {
    @Override
    public PersonCreatorI makePersonCreator() {
        return new PersonCreatorDB();
    }
}
