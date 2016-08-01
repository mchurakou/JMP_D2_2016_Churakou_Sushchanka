package com.company.person.factories;

import com.company.person.creators.HeandlerI;
import com.company.person.creators.HeandlerFileImpl;

/**
 * Factory for the person creator for the work with file.
 * Created by alt-hanny on 25.07.2016.
 */
public class HeandlerFileFactory extends HeandlerAbctractFactory {
    /** Makes the person creator. File implementation. */
    public HeandlerI makePersonCreator() {
        return new HeandlerFileImpl();
    }
}
