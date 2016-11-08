package com.company.springmvc.interfaces;

import com.company.springmvc.model.beans.User;

import java.util.List;

/**
 * Created by alt-hanny on 23.10.2016.
 */
public interface UserService {
    /** for search **/
    List<User> findAllUsers();
    User findUserById(Integer id);
    /** CRUD */
    void insert(User user);
    void update(User user);
    void delete(Integer userId);
}
