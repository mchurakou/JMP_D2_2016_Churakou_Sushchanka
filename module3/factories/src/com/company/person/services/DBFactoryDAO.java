package com.company.person.services;

import com.company.person.services.dbconnection.ConnectionDBImpl;

/**
 * Factory for the database connection implementations.
 * Created by alt-hanny on 25.07.2016.
 */
public class DBFactoryDAO {
    /** Gets the kind of the connection to database. */
    public ConnectionDBImpl getDAO () {
        return new ConnectionDBImpl();
    }
}
