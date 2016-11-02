package com.company.sushchanka.service;

import com.company.sushchanka.model.beans.Task;
import com.company.sushchanka.model.beans.User;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by alt-hanny on 30.10.2016.
 */
@WebService(endpointInterface = "com.company.sushchanka.service.UserWebServiceSEI",serviceName = "UserWebServiceImpl")
public class UserWebServiceImpl implements UserWebServiceSEI{
    
    private static final AtomicLong counter = new AtomicLong();
    private static List<User> users;
    private static final AtomicLong taskCounter = new AtomicLong();
    private static List<Task> tasks;
    
    static {
        users = populateDummyUsers();
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public User findById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByName(String name) {
        for(User user : users){
            if(user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }

    @Override
    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    @Override
    public void deleteUserById(long id) {
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    public List<Task> findAllUserTasks(long userId) {
        tasks = findById(userId).getTasks();
        if (tasks.isEmpty()){
            return null;
        }
        return tasks;
    }

    @Override
    public Task findUserTaskByIdTask(long userId, long taskId) {
        tasks = findById(userId).getTasks();
        for(Task task : tasks) {
            if(task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }


    @Override
    public void deleteAllUsers() {
        users.clear();
    }

    @Override
    public boolean isUserExist(User user) {
        return findByName(user.getName()) != null;
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
