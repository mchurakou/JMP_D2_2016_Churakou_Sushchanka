package com.company.springmvc.service;

import com.company.springmvc.model.beans.Task;
import com.company.springmvc.model.beans.User;

import java.util.List;

/**
 * Created by alt-hanny on 30.10.2016.
 */
public interface UserService {
    List<User> findAllUsers();
    User findById(long id);
    User findByName(String name);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(long id);
    void deleteAllUsers();
    boolean isUserExist(User user);
    List<Task> findAllUserTasks(long userId);
    Task findUserTaskByIdTask(long userId, long taskId);
}

