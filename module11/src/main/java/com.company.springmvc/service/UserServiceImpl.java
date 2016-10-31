package com.company.springmvc.service;

import com.company.springmvc.model.beans.Task;
import com.company.springmvc.model.beans.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by alt-hanny on 30.10.2016.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    
    private static final AtomicLong counter = new AtomicLong();
    private static List<User> users;
    
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
    public void deleteAllUsers() {
        users.clear();
    }

    @Override
    public boolean isUserExist(User user) {
        return findByName(user.getName()) != null;
    }

    private static List<User> populateDummyUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(counter.incrementAndGet(), "Hanna", "Sushchanka", "Asus200786@gmail.com",
                new ArrayList<>(Arrays.asList(new Task (1L, "A", "aaa", new Date("2016-10-06"), new Date("2016-11-11"))))));
        users.add(new User(counter.incrementAndGet(), "Anna", "Sushch", "Asus@gmail.com",
                new ArrayList<>(Arrays.asList(new Task (2L, "B", "bbb", new Date("2016-11-06"), new Date("2016-12-11"))))));
        return users;
    }
}
