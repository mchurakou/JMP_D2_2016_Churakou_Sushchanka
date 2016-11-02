package com.company.sushchanka.service;

import com.company.sushchanka.model.beans.Task;
import com.company.sushchanka.model.beans.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by alt-hanny on 02.11.2016.
 */
@WebService
public interface UserWebServiceSEI {
    @WebMethod
    List<User> findAllUsers();
    @WebMethod
    User findById(@WebParam long id);
    @WebMethod
    User findByName(@WebParam String name);
    @WebMethod
    void saveUser(User user);
    @WebMethod
    void updateUser(User user);
    @WebMethod
    void deleteUserById(@WebParam long id);
    @WebMethod
    void deleteAllUsers();
    @WebMethod
    boolean isUserExist(User user);
    @WebMethod
    List<Task> findAllUserTasks(@WebParam long userId);
    @WebMethod
    Task findUserTaskByIdTask(@WebParam long userId, @WebParam long taskId);
}
