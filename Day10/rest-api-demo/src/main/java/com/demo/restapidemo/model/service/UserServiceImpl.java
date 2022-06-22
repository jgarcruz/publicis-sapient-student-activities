package com.demo.restapidemo.model.service;
import com.demo.restapidemo.model.bean.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl {
    private static List<User> users = new ArrayList<User>();

    public User storeUser(User user)
    {
        int counter = users.size();
        user.setUserId(++counter);
        users.add(user);
        return user;
    }
    public List<User> getAllUsers()
    {
        return users;
    }
}
