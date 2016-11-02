package com.company.springmvc.service;

import com.company.springmvc.model.beans.Task;
import com.company.springmvc.model.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by alt-hanny on 02.11.2016.
 */
@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    UserService userService;

    private static final AtomicLong counterTasks = new AtomicLong();
    private static List<Task> tasks;

    @Override
    public List<Task> findAllUserTasks(long userId) {
        tasks = userService.findById(userId).getTasks();
        if (tasks.isEmpty()){
            return null;
        }
        return tasks;
    }

    @Override
    public Task findUserTaskByIdTask(long userId, long taskId) {
        tasks = userService.findById(userId).getTasks();
        for(Task task : tasks) {
            if(task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }

    @Override
    public boolean isTaskExist(long userId, Task task) {
        return findTaskByName(userId, task.getName()) != null ;
    }

    @Override
    public Task findTaskByName(long userId, String name) {
        tasks = userService.findById(userId).getTasks();
        for(Task task : tasks){
            if(task.getName().equalsIgnoreCase(name)){
                return task;
            }
        }
        return null;
    }

    @Override
    public void saveTask(long userId, Task task) {
        task.setId(counterTasks.incrementAndGet());
        userService.findById(userId).getTasks().add(task);
    }

    @Override
    public void updateUserTask(long userId, Task task) {
        tasks = userService.findById(userId).getTasks();
        int index = tasks.indexOf(task);
        tasks.set(index, task);
    }

    @Override
    public void deleteTaskOfUserById(long userId, long taskId) {
        tasks = userService.findById(userId).getTasks();
        for (Iterator<Task> iterator = tasks.iterator(); iterator.hasNext();) {
            Task task = iterator.next();
            if (task.getId() == taskId) {
                iterator.remove();
            }
        }
    }

    @Override
    public void deleteAllUserTasks(long userId) {
        tasks = userService.findById(userId).getTasks();
        tasks.clear();
    }
}
