package com.example.springbootdbdemo.exceptions;

public class ProfileNotFoundException extends Exception {
    public ProfileNotFoundException() {
        super();
    }

    public ProfileNotFoundException(String message) {
        super(message);
    }
}
