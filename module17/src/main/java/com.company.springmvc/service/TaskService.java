package com.company.springmvc.service;

import com.company.springmvc.model.beans.Task;

import java.util.List;

/**
 * Created by alt-hanny on 02.11.2016.
 */
public interface TaskService {
    List<Task> findAllUserTasks(long userId);

    Task findUserTaskByIdTask(long userId, long taskId);

    boolean isTaskExist(long userId, Task task);

    void saveTask(long userId, Task task);

    Task findTaskByName(long userId, String name);

    void updateUserTask(long userId, Task task);

    void deleteTaskOfUserById(long userId, long taskId);

    void deleteAllUserTasks(long userId);
}
