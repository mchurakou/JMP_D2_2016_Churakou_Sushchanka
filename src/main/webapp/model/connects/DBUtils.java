package connects;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import factories.ConnectionFactoryDAO;

public class DBUtils {
	private static ConnectionDBImpl connectionDAO = new ConnectionFactoryDAO().getClassFromFactory();

	public static void createDB() {
		 try (Connection connection = connectionDAO.getConnection();
				 Statement statement = connection.createStatement()) {
				 statement.executeUpdate(ConstantsQueriesSQL.CREATE_DB);
				 statement.executeQuery("CREATE_USERS_TABLE");
				 statement.executeQuery("CREATE_NOTES_TABLE");
		 } catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
