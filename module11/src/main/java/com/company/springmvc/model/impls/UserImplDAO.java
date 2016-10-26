package com.company.springmvc.model.impls;

import com.company.springmvc.model.beans.User;
import com.company.springmvc.model.interfaces.IUserDAO;

/**
 * Created by alt-hanny on 27.10.2016.
 */
public class UserImplDAO implements IUserDAO {
    @Override
    public boolean validate(String login, String password) throws Exception {
        return false;
    }

    @Override
    public boolean add(User user) throws Exception {
        return false;
    }

    @Override
    public User getUser(String login, String password) throws DAOException {
        return null;
    }
}
