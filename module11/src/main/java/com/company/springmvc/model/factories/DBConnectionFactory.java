package com.company.springmvc.model.factories;

import com.company.springmvc.model.connections.ConnectionDBImpl;
import com.company.springmvc.model.connections.IConnectionDBDAO;

/**
 * Created by alt-hanny on 23.10.2016.
 */
public class DBConnectionFactory {
    public IConnectionDBDAO getConnection() {
        return new ConnectionDBImpl();
    }
}
