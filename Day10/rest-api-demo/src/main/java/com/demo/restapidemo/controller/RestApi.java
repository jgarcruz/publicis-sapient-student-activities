package com.demo.restapidemo.controller;

import com.demo.restapidemo.model.bean.User;
import com.demo.restapidemo.model.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/user")
public class RestApi {
    //Fetch user
    @Autowired
    private UserServiceImpl service;

    @PostMapping
    public User store(@RequestBody User user)
    {
        User createdUser = service.storeUser(user);
        return createdUser;
    }
    @GetMapping
    public List<User> getUser()
    {
        return service.getAllUsers();
    }
}
