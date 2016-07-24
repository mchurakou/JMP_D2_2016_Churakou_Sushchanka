package com.company.person.services.dbconnection;

import com.company.person.exceptions.ExceptionDAO;
import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by alt-hanny on 24.07.2016.
 */
public class ConnectionDBImpl implements IConnectionDB {

    private static Connection connection = null;
    private static JdbcConnectionPool pool;
    private static final String ERROR_H2_SQL_CONNECTION = "Error obtaining the H2 SQL connection";
    private static final String ERROR_CLOSING_H2_SQL_CONNECTION = "Error closing the H2 SQL Connection";

    public static void setConnectionPool(JdbcConnectionPool pool) {
        ConnectionDBImpl.pool = pool;
    }
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

    public static void closeConnection(Connection connection)
            throws ExceptionDAO {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ExceptionDAO(ERROR_CLOSING_H2_SQL_CONNECTION);
            }
        }
    }
}
