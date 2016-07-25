package com.company.person.services.dbconnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by alt-hanny on 24.07.2016.
 */
interface IConnectionDB {
    Connection getConnection() throws SQLException;
}
