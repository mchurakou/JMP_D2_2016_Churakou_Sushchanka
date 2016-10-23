package com.company.springmvc.model.interfaces;

import com.company.springmvc.model.beans.User;
import com.company.springmvc.model.impls.DAOException;

/**
 * Created by alt-hanny on 23.10.2016.
 */
public interface IUserDAO {
    boolean validate(String login, String password) throws Exception;
    boolean add(User user) throws Exception;
    User getUser(String login, String password) throws DAOException;
}
