package com.company.person.factories;

import com.company.person.creators.PersonCreatorI;

/**
 * Abstract Factory for person creators.
 */
public abstract class PersonCreatorAbctractFactory {
    /** Makes the person creator. */
    public abstract PersonCreatorI makePersonCreator();
}
