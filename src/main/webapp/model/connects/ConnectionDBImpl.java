package connects;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDBImpl {
	Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    /** JDBC driver name. */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    /**  Database URL.*/
    static final String DB_URL = "jdbc:mysql://localhost:3306/module11";
    /** Database credentials. */
    static final String USER = "root";
    static final String PASS = "admin";

    /** Gets the connection to database. */
    public Connection getConnection() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
        return connection;
    }
    
    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
