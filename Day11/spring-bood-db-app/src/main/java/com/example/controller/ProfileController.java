package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.exceptions.ProfileNotFoundException;
import com.example.model.beans.Friend;
import com.example.model.beans.Profile;
import com.example.model.service.FriendService;
import com.example.model.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private FriendService friendService;
	
	@PostMapping
	public ResponseEntity<Object> store(@RequestBody Profile profile) { // profileId, name, dob, phone
		Profile storedProfile = profileService.storeProfile(profile);
		return ResponseEntity.status(HttpStatus.CREATED).body(storedProfile);
	}
	@GetMapping
	public ResponseEntity<Object> getProfiles() {
		List<Profile> list = profileService.fetchProfiles();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Object> getProfile(@PathVariable("id") int id) {
		try {
			Profile profile = profileService.fetchProfile(id);
			return ResponseEntity.status(HttpStatus.OK).body(profile);
		} catch (ProfileNotFoundException e) {
			// Exception has getMessage() that returns the message initialized when exception occurs
			Map<String, String> map = new HashMap<String, String>();
			map.put("error", e.getMessage()); // e.getMessage(): Profile with an id not found
			map.put("status", "404");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		}	
	}
	@PutMapping("/{id}/{phone}")
	public ResponseEntity<Object> modifyPhone(int id, long phone) throws ProfileNotFoundException
	{
		try{
			Profile profile = profileService.fetchProfile(id);
			return ResponseEntity.status(HttpStatus.OK).body(profile);
		}
		catch(ProfileNotFoundException e)
		{
			// Exception has getMessage() that returns the message initialized when exception occurs
			Map<String, String> map = new HashMap<String, String>();
			map.put("error", e.getMessage()); // e.getMessage(): Profile with an id not found
			map.put("status", "404");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		}
	}
	@PostMapping("/{profileId}")
	public ResponseEntity<Object> addFriend(@RequestBody Friend friend, 
			@PathVariable("profileId") int id) {
		Friend createdFriend = friendService.addFriend(id, friend);
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "Added "+createdFriend.getName());
		map.put("description", "Added to profile id: "+createdFriend.getProfileIdRef());
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}
	@DeleteMapping("/{profileId}/")
	public ResponseEntity<Object> removeFriend(@RequestBody Friend friend, @PathVariable("profileId") int id) throws ProfileNotFoundException
	{
		try {
			friendService.removeFriend(id, friend);
			return ResponseEntity.status(HttpStatus.OK).body(friend);
		} catch(ProfileNotFoundException e)
		{
			// Exception has getMessage() that returns the message initialized when exception occurs
			Map<String, String> map = new HashMap<String, String>();
			map.put("error", e.getMessage()); // e.getMessage(): Profile with an id not found
			map.put("status", "404");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		}
	}
	@PutMapping("/{id}/?{phone}")
	public ResponseEntity<Object> modPhoneFriend(@RequestBody Friend friend, @PathVariable("profileId") int id, @PathVariable("phone") long phone)
	{
		try{
			friendService.modFriendPhone(id, friend, phone);
			return ResponseEntity.status(HttpStatus.OK).body(friend);
		} catch(ProfileNotFoundException e)
		{
			// Exception has getMessage() that returns the message initialized when exception occurs
			Map<String, String> map = new HashMap<String, String>();
			map.put("error", e.getMessage()); // e.getMessage(): Profile with an id not found
			map.put("status", "404");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		}
	}
}
