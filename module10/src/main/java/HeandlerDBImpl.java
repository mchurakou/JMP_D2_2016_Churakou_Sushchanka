import beans.Friendship;
import beans.Like;
import beans.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.List;

/**
 * Implements the creator with database.
 */
public class HeandlerDBImpl {
    static final Logger logger = LogManager.getLogger(HeandlerDBImpl.class);
    /** Constant for the reading person query. */
    private static final String CREATE_DATABASE = "CREATE_DB";
    /** Constant for the writing person query. */
    private static final String DROP_TABLES = "DROP_TABLES";
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
        String creatingUserTableQuery = queriesFactory.getQuery(QueriesEnum.CREATE_USERS_TABLE.name());
        String creatingFriendsShipsTableQuery = queriesFactory.getQuery(QueriesEnum.CREATE_FRIENDSSHIPS_TABLE.name());
        String creatingPostsTableQuery = queriesFactory.getQuery(QueriesEnum.CREATE_POSTS_TABLE.name());
        String creatingLikesTableQuery = queriesFactory.getQuery(QueriesEnum.CREATE_LIKES_TABLE.name());
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
        String query = queriesFactory.getQuery(QueriesEnum.INSERT_USER.name());

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
                   preparedStatement.setDate(3, DBUtils.generateRandomDate(1930, 2006));
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
        String query = queriesFactory.getQuery(QueriesEnum.INSERT_FRIENDSHIP.name());
        try ( Connection connection = connectionDAO.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            List<Friendship> friendshipList = DBUtils.generateFriendships();
            for(Friendship friendship : friendshipList) {
                preparedStatement.setInt(1, friendship.getUserId1());
                preparedStatement.setInt(2, friendship.getUserId2());
                preparedStatement.setTimestamp(3, friendship.getTimestamp());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Fills the friendships table.
     */
    public void fillPosts() {
        String query = queriesFactory.getQuery(QueriesEnum.INSERT_POST.name());
        try ( Connection connection = connectionDAO.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            List<Post> postsList = DBUtils.generatePosts();
            for(Post post : postsList) {
                preparedStatement.setInt(1, post.getId());
                preparedStatement.setInt(2, post.getUserId());
                preparedStatement.setString(3, post.getText());
                preparedStatement.setTimestamp(4, post.getTimestamp());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public void fillLikes() {
        String query = queriesFactory.getQuery(QueriesEnum.INSERT_LIKE.name());
        try ( Connection connection = connectionDAO.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            List<Like> likesList = DBUtils.generateLikes();
            for(Like like : likesList) {
                preparedStatement.setInt(1, like.getPostId());
                preparedStatement.setInt(2, like.getUserId());
                preparedStatement.setTimestamp(3, like.getTimestamp());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
