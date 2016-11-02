package com.company.sushchanka;

import com.company.sushchanka.service.User;
import com.company.sushchanka.service.UserServiceImpl;
import com.company.sushchanka.service.UserServiceImplService;

import java.util.List;

/**
 * Hello world!
 *
 */
public class SOAPClient
{
    public static void main( String[] args )
    {
        UserServiceImpl services = new UserServiceImplService().getUserServiceImplPort();
       List<User> users = services.findAllUsers();
        for(User user : users)
            System.out.println(user.getMail());
    }
}
