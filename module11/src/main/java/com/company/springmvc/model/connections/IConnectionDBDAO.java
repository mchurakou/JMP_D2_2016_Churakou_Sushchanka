package com.company.springmvc.model.connections;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by alt-hanny on 23.10.2016.
 */
public interface IConnectionDBDAO {
    Connection getConnection() throws SQLException;
}
