import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by alt-hanny on 13.09.2016.
 */
public class Runner {
    static final Logger logger = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        HeandlerDBImpl heandlerDB = new HeandlerDBImpl();
        heandlerDB.createTables();
        heandlerDB.fillUsers();
        heandlerDB.fillFriendships();
        heandlerDB.fillPosts();
        heandlerDB.fillLikes();

    }
}
