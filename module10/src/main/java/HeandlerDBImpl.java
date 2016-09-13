import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
    }

//    /**
//     * Writes the person to database.
//     * @param person Person.
//     */
//    public void writePerson(Person person) {
//        String query = queriesFactory.getQuery(WRITE_PERSON);
//
//        try ( Connection connection = connectionDAO.getConnection();
//              PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setLong(1, person.getId());
//            preparedStatement.setString(2, person.getName());
//            preparedStatement.setInt(3, person.getAge());
//            preparedStatement.executeUpdate();
//        } catch (SQLException | IllegalArgumentException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * Reads the person from database.
//     * @return Person.
//     */
//    public Person readPerson() {
//        String query = queriesFactory.getQuery(READ_PERSON);
//        Person person = null;
//        try ( Connection connection = connectionDAO.getConnection();
//              PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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
