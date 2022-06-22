package com.demo.restapidemo.controller;

import com.demo.restapidemo.model.bean.User;
import com.demo.restapidemo.model.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> store(@RequestBody User user)
    {
        User createdUser = service.storeUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable("userId") int id)
    {
        List<User> users = service.getAllUsers();
        users.size();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    @GetMapping("/abs/{userId}")
    public ResponseEntity<Object> fetchUser(@PathVariable("userId") int id) {
        Map<String, String> map = new HashMap<String, String>();
        List<User> users = service.getAllUsers();
        for (User u:users)
        {
            if(u.getUserId() == id)
            {
                map.put("userId", "Valid id: " + id);
                map.put("name", u.getName());
                return ResponseEntity.status(HttpStatus.OK).body(map);
            }
        }
        map.put("error", "invalid id: " + id);
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @PutMapping("/abs/{userId}/{dob}")
    public ResponseEntity<Object> updateDOB(@PathVariable("userId") int id, @PathVariable("dob") String dob) {
        Map<String, String> map = new HashMap<String, String>();
        List<User> users = service.getAllUsers();
        for (User u:users)
        {
            if(u.getUserId() == id)
            {
                map.put("userId", "Valid id: " + id);
                u.setDob(LocalDate.parse(dob));
                map.put("Set " + u.getName() + "'s DOB to", u.getDob().toString());
                return ResponseEntity.status(HttpStatus.OK).body(map);
            }
        }
        map.put("error", "invalid id: " + id);
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
    @DeleteMapping("/abs/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable("userId") int id) {
        Map<String, String> map = new HashMap<String, String>();
        List<User> users = service.getAllUsers();
        for (User u:users)
        {
            if(u.getUserId() == id)
            {
                map.put("userId", "Valid id: " + id);
                map.put("REMOVED:", u.getName());
                users.remove(u);
                return ResponseEntity.status(HttpStatus.OK).body(map);
            }
        }
        map.put("error", "invalid id: " + id);
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
