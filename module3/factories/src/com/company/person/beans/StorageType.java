package com.company.person.beans;

import com.company.person.factories.HeandlerAbctractFactory;
import com.company.person.factories.HeandlerDBFactory;
import com.company.person.factories.HeandlerFileFactory;

/**
 * Created by alt-hanny on 27.07.2016.
 */
public enum StorageType {
    FILE {
        @Override
        public HeandlerAbctractFactory getStorageType() {
           return new HeandlerFileFactory();
        }
    },
    H2_DATABASE {
        @Override
        public HeandlerAbctractFactory getStorageType() {
            return new HeandlerDBFactory();
        }
    };
    public abstract HeandlerAbctractFactory getStorageType();
}
