package com.company.person.factories;

import com.company.person.creators.PersonCreater;
import com.company.person.creators.PersonCreaterFile;

/**
 * Created by alt-hanny on 25.07.2016.
 */
public class PersonCreaterFileFactory extends PersonCreaterAbctractFactory {
    @Override
    public PersonCreater makePersonCreater() {
        return new PersonCreaterFile();
    }
}
