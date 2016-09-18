package factories;

import implementations.UserImplDAO;

public class UserFactory {
	/**
	 * Gets the dao.
	 * 
	 * @return DAO class
	 * 
	 * @throws DAOException
	 */
	public static IUserDAO getClassFromFactory(){
		return  UserImplDAO.getInstance();
	}

}
