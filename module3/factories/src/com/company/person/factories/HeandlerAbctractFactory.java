package com.company.person.factories;

import com.company.person.creators.HeandlerI;

/**
 * Abstract Factory for person creators.
 */
public abstract class HeandlerAbctractFactory {
    /** Makes the person creator. */
    public abstract HeandlerI makePersonCreator();
}
