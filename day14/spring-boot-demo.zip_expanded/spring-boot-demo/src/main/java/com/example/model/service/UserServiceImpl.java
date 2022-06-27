package com.example.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.beans.User;

// This object is automatically created & registered in the spring container
// it can be @Autowired to other objects present in the spring container
// Note: we must use interface and implement it here, but for demo purpose we are using class directly
@Service
public class UserServiceImpl {
	// A List<User> which acts like a temporary DB to store User data
	private static List<User> usersList = new ArrayList<User>();
	
	// method to add user to the usersList and return the stored user, use will have name & dob
	public User storeUser(User user) {
		int counter = usersList.size();
		user.setUserId(++counter); // setting user id to the user object
		usersList.add(user);
		return user;
	}
	// method to return all the users in the form of list
	public List<User> getAllUsers() {
		return usersList;
	}
}
