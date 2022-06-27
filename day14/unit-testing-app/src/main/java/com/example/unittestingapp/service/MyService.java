package com.example.unittestingapp.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    public String welcome(String name){
        return "Welcome " +name;
    }
}
