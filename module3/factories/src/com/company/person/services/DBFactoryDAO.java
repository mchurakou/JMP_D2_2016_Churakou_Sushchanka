package com.company.person.services;

import com.company.person.services.dbconnection.ConnectionDBImpl;

/**
 * Created by alt-hanny on 25.07.2016.
 */
public class DBFactoryDAO {
    public ConnectionDBImpl getDAO () {
        return new ConnectionDBImpl();
    }
}
