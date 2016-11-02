package com.company.sushchanka.service;

import com.company.sushchanka.model.beans.Task;
import com.company.sushchanka.model.beans.User;

import javax.jws.*;
import java.util.List;

/**
 * Created by alt-hanny on 30.10.2016.
 */
@WebService
public interface UserService {
    @WebMethod
    List<User> findAllUsers();
    @WebMethod
    User findById(@WebParam(name = "UserID")long id);
    @WebMethod
    User findByName(@WebParam(name = "UserName")String name);
    @Oneway
    void saveUser(@WebParam(name = "User") User user);
    @Oneway
    void updateUser(User user);
    @Oneway
    void deleteUserById(@WebParam(name = "UserID") long id);
    @Oneway
    void deleteAllUsers();
    @WebResult(name = "IsUserExists")
    @WebMethod
    boolean isUserExist(@WebParam(name = "User") User user);
    @WebMethod
    List<Task> findAllUserTasks(@WebParam(name = "UserID")long userId);
    @WebMethod
    Task findUserTaskByIdTask(@WebParam(name = "UserID")long userId,@WebParam(name = "TaskID") long taskId);
    @WebResult(name = "IsTaskExists")
    @WebMethod
    boolean isTaskExist(@WebParam(name = "UserID")long userId, @WebParam(name = "Task") Task task);
    @Oneway
    void saveTask(@WebParam(name = "UserID")long userId, @WebParam(name = "Task") Task task);
    @WebMethod
    Task findTaskByName(@WebParam(name = "UserID")long userId, @WebParam(name = "TaskName") String name);
    @Oneway
    void updateUserTask(@WebParam(name = "UserID")long userId, @WebParam(name = "Task") Task task);
    @Oneway
    void deleteTaskOfUserById(@WebParam(name = "UserID")long userId,@WebParam(name = "TaskID") long taskId);
    @Oneway
    void deleteAllUserTasks(@WebParam(name = "UserID")long userId);
}

