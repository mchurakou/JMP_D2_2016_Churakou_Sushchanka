package com.company.person.services.dbconnection;

import com.company.person.exceptions.ExceptionDAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by alt-hanny on 24.07.2016.
 */
public interface IConnectionDB {
    Connection getConnection() throws ExceptionDAO, SQLException;
}
