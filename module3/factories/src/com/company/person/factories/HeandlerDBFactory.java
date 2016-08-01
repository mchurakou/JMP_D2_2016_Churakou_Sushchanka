package com.company.person.factories;

import com.company.person.creators.HeandlerI;
import com.company.person.creators.HeandlerDBImpl;

/**
 * Factory for the person creator for the work with database.
 * Created by alt-hanny on 25.07.2016.
 */
public class HeandlerDBFactory extends HeandlerAbctractFactory {
    /** Makes the person creator with database. */
    @Override
    public HeandlerI makePersonCreator() {
        return new HeandlerDBImpl();
    }
}
