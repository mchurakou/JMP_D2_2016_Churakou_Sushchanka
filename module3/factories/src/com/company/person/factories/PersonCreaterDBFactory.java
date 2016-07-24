package com.company.person.factories;

import com.company.person.creators.PersonCreater;
import com.company.person.creators.PersonCreatorDB;

/**
 * Created by alt-hanny on 25.07.2016.
 */
public class PersonCreaterDBFactory extends PersonCreaterAbctractFactory {
    @Override
    public PersonCreater makePersonCreater() {
        return new PersonCreatorDB();
    }
}
