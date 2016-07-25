package com.company.person.factories;

import com.company.person.creators.PersonCreatorI;

/**
 * Created by alt-hanny on 24.07.2016.
 */
public abstract class PersonCreatorAbctractFactory {
    public abstract PersonCreatorI makePersonCreator();
}
