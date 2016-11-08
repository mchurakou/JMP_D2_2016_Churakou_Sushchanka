package com.company.springmvc.connections;

import com.company.springmvc.utils.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by alt-hanny on 23.10.2016.
 */
public class ConnectionDBImpl implements IConnectionDBDAO {
    /**  Variable for the connection. */
    private static Connection connection = null;
    /** Constant for the class name. */
    private final String DRIVER_CLASS_NAME = "org.h2.Driver";
    /** Constant for the database URL. */
    private final String DB_URL = "jdbc:h2:~/module11";
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
