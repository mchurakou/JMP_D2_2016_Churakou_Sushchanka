package factories;

import connects.ConnectionDBImpl;

public class ConnectionFactoryDAO {
	/** Gets the kind of the connection to database. */
    public ConnectionDBImpl getClassFromFactory () {
        return new ConnectionDBImpl();
    }
}
