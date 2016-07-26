package com.company.person.services.dbconnection;

import com.company.person.constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for work with the connection to database.
 * Created by alt-hanny on 24.07.2016.
 */
public class ConnectionDBImpl implements IConnectionDB {
    /**  Variable for the connection. */
    private static Connection connection = null;
    /** Constant for the class name. */
    private final String DRIVER_CLASS_NAME = "org.h2.Driver";
    /** Constant for the database URL. */
    private final String DB_URL = "jdbc:h2:~/test";
    /** Constant for the login of the database. */
    private final String LOGIN = "sa";
    /** Constant for the password of the database. */
    private final String PASSWORD = "sa";

    /** Gets the connection to database. */
    @Override
    public Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER_CLASS_NAME);
            connection = DriverManager.getConnection(DB_URL,LOGIN,PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException(Constants.ERROR_H2_SQL_CONNECTION);
        }
        return connection;
    }
}
