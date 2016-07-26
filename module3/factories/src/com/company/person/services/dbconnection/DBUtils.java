package com.company.person.services.dbconnection;

import java.sql.*;

/**
 * Created by alt-hanny on 27.07.2016.
 */
public class DBUtils {
    private Connection connection;


    public DBUtils(Connection connection) {
        this.connection = connection;
    }

    /**
     * Checks if the table exists.
     * @return false if table not exists.
     * @throws SQLException
     */
    public boolean isTableExists(Connection connection) throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null, "person", new String[] { "TABLE" });
        return resultSet.next() ? true : false;
    }
}
