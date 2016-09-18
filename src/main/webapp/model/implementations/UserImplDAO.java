package implementations;

import beans.User;
import factories.IUserDAO;

public class UserImplDAO implements IUserDAO{

	private static UserImplDAO instance;

	private UserImplDAO() {
	}

	public synchronized static UserImplDAO getInstance() {
		if (instance == null) {
			instance = new UserImplDAO();
		}
		return instance;
	}

	@Override
	public boolean validate(String login, String password) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(User user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(String login, String password) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
