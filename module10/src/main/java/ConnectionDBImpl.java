import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Utility class for work with the connection to database.
 * Created by alt-hanny on 24.07.2016.
 */
public class ConnectionDBImpl
{
    Connection connection = null;
    Statement statement = null;
    /** JDBC driver name. */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    /**  Database URL.*/
    static final String DB_URL = "jdbc:mysql://localhost:3306/module10";
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
}
