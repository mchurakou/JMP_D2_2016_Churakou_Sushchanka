package com.company.person.services.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by alt-hanny on 24.07.2016.
 */
public class ConnectionDBImpl implements IConnectionDB {

    private static Connection connection = null;
    private static final String ERROR_H2_SQL_CONNECTION = "Error obtaining the H2 SQL connection";

    @Override
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/test","sa","sa");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException(ERROR_H2_SQL_CONNECTION);
        }
        return connection;
    }
}
