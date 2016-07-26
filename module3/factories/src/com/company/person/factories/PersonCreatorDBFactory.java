package com.company.person.factories;

import com.company.person.creators.PersonCreatorI;
import com.company.person.creators.PersonCreatorDBImpl;

/**
 * Factory for the person creator for the work with database.
 * Created by alt-hanny on 25.07.2016.
 */
public class PersonCreatorDBFactory extends PersonCreatorAbctractFactory {
    /** Makes the person creator with database. */
    @Override
    public PersonCreatorI makePersonCreator() {
        return new PersonCreatorDBImpl();
    }
}
