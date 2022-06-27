package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController to make this class as Rest API
//@RequestMapping to give the entry point URL
@RestController
@RequestMapping("/api/first")
public class FirstRest {

	// this returns text, for GET /api/first
	@GetMapping
	public String greetings() {
		return "Welcome to REST";
	}
	// this returns JSON because it returns object, request GET /api/first/hello
	@GetMapping("/hello")
	public Map<String, String> getComplex() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "Alexandar");
		map.put("email", "alexandar1234@abc.com");
		return map;
	}
}
