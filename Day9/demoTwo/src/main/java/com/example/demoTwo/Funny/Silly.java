package com.example.demoTwo.Funny;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/first")
public class Silly {

	@GetMapping
	public String greetings()
	{
		return "Welcome to REST";
	}
	
	@GetMapping("/hello")
	public Map<String, String> getComplex()
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "hello all!");
		return map;
	}
	@PostMapping("/hello")
	public Map<String, String> create()
	{
		Map<String, String> map = new HashMap<>();
		map.put("message", "Hello post");
		return map;
	}
	@PutMapping("/hello")
	public Map<String, String> createPut()
	{
		Map<String, String> map = new HashMap<>();
		map.put("message", "Hello put");
		return map;
	}
	@DeleteMapping("/hello")
	public Map<String, String> createDelete()
	{
		Map<String, String> map = new HashMap<>();
		map.put("message", "Hello delete");
		return map;
	}
}
