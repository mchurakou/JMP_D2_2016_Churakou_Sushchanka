import java.sql.SQLException;

/**
 * Created by alt-hanny on 13.09.2016.
 */
public class Runner {
    public static void main(String[] args) throws SQLException {
        HeandlerDBImpl heandlerDB = new HeandlerDBImpl();
        heandlerDB.createTables();
        heandlerDB.fillUsers();
        heandlerDB.fillFriendships();
        heandlerDB.fillPosts();
        heandlerDB.fillLikes();
        heandlerDB.resultExecution();
    }
}
