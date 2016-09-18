package factories;

import beans.User;
import implementations.DAOException;

public interface IUserDAO {
	boolean validate(String login, String password) throws Exception;

	boolean add(User user) throws Exception;

	User getUser(String login, String password) throws DAOException;
}
