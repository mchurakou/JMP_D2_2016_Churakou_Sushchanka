package com.company.springmvc.factories;

import com.company.springmvc.connections.ConnectionDBImpl;
import com.company.springmvc.connections.IConnectionDBDAO;

/**
 * Created by alt-hanny on 23.10.2016.
 */
public class DBConnectionFactory {
    public IConnectionDBDAO getConnection() {
        return new ConnectionDBImpl();
    }
}
