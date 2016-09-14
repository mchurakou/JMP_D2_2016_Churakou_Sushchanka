import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

/**
 * Implements the creator with database.
 */
public class HeandlerDBImpl {
    static final Logger logger = LogManager.getLogger(HeandlerDBImpl.class);
    /** Constant for the reading person query. */
    private static final String CREATE_DATABASE = "CREATE_DB";
    /** Constant for the writing person query. */
    private static final String DROP_TABLES = "DROP_TABLES";
    private static final String CREATE_USERS_TABLE = "CREATE_USERS_TABLE";
    private static final String CREATE_FRIENDSSHIPS_TABLE = "CREATE_FRIENDSSHIPS_TABLE";
    private static final String CREATE_POSTS_TABLE = "CREATE_POSTS_TABLE";
    private static final String CREATE_LIKES_TABLE = "CREATE_LIKES_TABLE";
    private static final String INSERT_USER = "INSERT_USER";
    private static final String INSERT_FRIENDSHIP = "INSERT_FRIENDSHIP";



    /** Gets connection. */
    private ConnectionDBImpl connectionDAO = new DBFactoryDAO().getDAO();
    /** Queries factory. */
    private QueriesFactory queriesFactory = new QueriesFactory();

    public HeandlerDBImpl() {
        init();
    }

    private void init() {
        final String query_create_db = queriesFactory.getQuery(CREATE_DATABASE);
        final String query_drop_tables = queriesFactory.getQuery(DROP_TABLES);
        try (Connection connection = connectionDAO.getConnection();
             Statement statement = connection.createStatement()) {
             statement.executeUpdate(query_create_db);
            logger.info("Database updated.");
             statement.executeUpdate(query_drop_tables);
            logger.info("Tables were dropped.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates tables.
     * @throws SQLException
     */
    public void createTables() {
        String creatingUserTableQuery = queriesFactory.getQuery(CREATE_USERS_TABLE);
        String creatingFriendsShipsTableQuery = queriesFactory.getQuery(CREATE_FRIENDSSHIPS_TABLE);
        String creatingPostsTableQuery = queriesFactory.getQuery(CREATE_POSTS_TABLE);
        String creatingLikesTableQuery = queriesFactory.getQuery(CREATE_LIKES_TABLE);
        try (Connection connection = connectionDAO.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(creatingUserTableQuery);
            statement.executeUpdate(creatingFriendsShipsTableQuery);
            statement.executeUpdate(creatingPostsTableQuery);
            statement.executeUpdate(creatingLikesTableQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        logger.info("Tables were created.");
    }

    /**
     * Fills the Users table.
     */
    public void fillUsers() {
        String query = queriesFactory.getQuery(INSERT_USER);

        try (Connection connection = connectionDAO.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query)) {
           try (FileReader fileReader = new FileReader("module10/src/main/resources/users.csv");
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
               String line;
               while ((line = bufferedReader.readLine()) != null) {
                   String[] userData = line.split(",");
                   String userName = userData[0];
                   String userSurname = userData[1];
                   preparedStatement.setString(1, userName);
                   preparedStatement.setString(2, userSurname);
                   preparedStatement.setTimestamp(3, DBUtils.generateRandomTimastamp());
                   preparedStatement.executeUpdate();
               }
           }
        } catch (IOException | SQLException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Fills the friendships table.
     */
    public void fillFriendships () {
        String query = queriesFactory.getQuery(INSERT_FRIENDSHIP);
        try ( Connection connection = connectionDAO.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for(int i = 0; i < 70000; i++) {
//                preparedStatement.setInt(1, );
            }

        } catch (SQLException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
//
//    /**
//     * Reads the person by name from database.
//     * @param name Person's name.
//     * @return Object Person.
//     */
//    public Person readPerson(String name) {
//        String query = queriesFactory.getQuery(READ_PERSON_BY_NAME);
//
//        Person person = null;
//
//        try ( Connection connection = connectionDAO.getConnection();
//              PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setString(1, name);
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//                    person = createPerson(resultSet);
//                }
//            }
//        } catch (SQLException | IllegalArgumentException e) {
//            throw new RuntimeException(e);
//        }
//        return person;
//    }
//
//    /**
//     * Creates the person.
//     * @param resultSet result set.
//     * @return Person.
//     * @throws SQLException
//     */
//    private Person createPerson (ResultSet resultSet) throws SQLException {
//        Person person = new Person();
//        person.setId(resultSet.getInt(Constants.PERSON_ID));
//        person.setName(resultSet.getString(Constants.PERSON_NAME));
//        person.setAge(resultSet.getInt(Constants.PERSON_AGE));
//        return person;
//    }
}
