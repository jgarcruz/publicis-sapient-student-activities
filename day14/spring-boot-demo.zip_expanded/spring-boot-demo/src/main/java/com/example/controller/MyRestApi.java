package com.example.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.beans.User;
import com.example.model.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class MyRestApi {

	// auto-inject service 
	@Autowired
	private UserServiceImpl service;
	
	// storing the user
	@PostMapping
	public ResponseEntity<Object> store(@RequestBody User user) {
		User createdUser = service.storeUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	// fetching all the users
	@GetMapping
	public ResponseEntity<Object> fetchUsers() {
		List<User> users = service.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@GetMapping("/abc/{userId}")
	public ResponseEntity<Object> getMessage(@PathVariable("userId") int id, 
		 @RequestParam("username") String name) {
		Map<String, String> map = new HashMap<String, String>();
		if(id < 0) {
			map.put("error", "id is invalid: "+id);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		} else {
			map.put("message", "Valid id: "+id);
			map.put("name", name);
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}
		
	}
}
