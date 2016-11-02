package com.company.sushchanka.service;

import com.company.sushchanka.model.beans.Task;
import com.company.sushchanka.model.beans.User;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by alt-hanny on 30.10.2016.
 */
@WebService//(endpointInterface = "com.company.sushchanka.service.UserService")
@Transactional
public class UserServiceImpl implements UserService{
    
    private static final AtomicLong counter = new AtomicLong();
    private static List<User> users;
    private static final AtomicLong counterTasks = new AtomicLong();
    private static List<Task> tasks;
    
    static {
        users = populateDummyUsers();
    }

    public List<User> findAllUsers() {
        return users;
    }

    public User findById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User findByName(String name) {
        for(User user : users){
            if(user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }

    public void saveUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }

    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    public void deleteUserById(long id) {
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }

    public void deleteAllUsers() {
        users.clear();
    }

    public boolean isUserExist(User user) {
        return findByName(user.getName()) != null;
    }

    public List<Task> findAllUserTasks(long userId) {
        tasks = findById(userId).getTasks();
        if (tasks.isEmpty()){
            return null;
        }
        return tasks;
    }

    public Task findUserTaskByIdTask(long userId, long taskId) {
        tasks = findById(userId).getTasks();
        for(Task task : tasks) {
            if(task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }

    public boolean isTaskExist(long userId, Task task) {
        return findTaskByName(userId, task.getName()) != null ;
    }

    public Task findTaskByName(long userId, String name) {
        tasks = findById(userId).getTasks();
        for(Task task : tasks){
            if(task.getName().equalsIgnoreCase(name)){
                return task;
            }
        }
        return null;
    }

    public void saveTask(long userId, Task task) {
        task.setId(counterTasks.incrementAndGet());
        findById(userId).getTasks().add(task);
    }

    public void updateUserTask(long userId, Task task) {
        tasks = findById(userId).getTasks();
        int index = tasks.indexOf(task);
        tasks.set(index, task);
    }

    public void deleteTaskOfUserById(long userId, long taskId) {
        tasks = findById(userId).getTasks();
        for (Iterator<Task> iterator = tasks.iterator(); iterator.hasNext();) {
            Task task = iterator.next();
            if (task.getId() == taskId) {
                iterator.remove();
            }
        }
    }

    public void deleteAllUserTasks(long userId) {
        tasks = findById(userId).getTasks();
        tasks.clear();
    }
    private static List<User> populateDummyUsers(){
        List<User> users = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();
        try {
            tasks.add(new Task(1, "A", "aaa", new SimpleDateFormat("yyyy-MM-dd").parse("2016-06-11"), new SimpleDateFormat("yyyy-MM-dd").parse("2016-06-12")));
            tasks.add(new Task(2, "A", "aaa", new SimpleDateFormat("yyyy-MM-dd").parse("2016-06-10"), new SimpleDateFormat("yyyy-MM-dd").parse("2016-06-15")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        users.add(new User(counter.incrementAndGet(), "Hanna", "Sushchanka", "Asus200786@gmail.com", tasks));
        users.add(new User(counter.incrementAndGet(), "Anna", "Sushch", "Asus@gmail.com", tasks));
        return users;
    }


}
