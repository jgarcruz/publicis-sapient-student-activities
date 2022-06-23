package com.example.springbootdbdemo.controller;

import com.example.springbootdbdemo.beans.Profile;
import com.example.springbootdbdemo.exceptions.ProfileNotFoundException;
import com.example.springbootdbdemo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<Object> store(@RequestBody Profile profile){
        Profile storedProfile = profileService.storeProfile(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(storedProfile);
    }

    @GetMapping
    public ResponseEntity<Object> getProfiles()
    {
        List<Profile> list = profileService.fetchProfiles();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProfile(@PathVariable("id") int id)
    {
        try{
            Profile profile = profileService.fetchProfile(id);
            return ResponseEntity.status(HttpStatus.OK).body(profile);
        } catch(ProfileNotFoundException e)
        {
            Map<String, String> map = new HashMap<>();
            map.put("error", e.getMessage());
            map.put("status", "404");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
        }
    }
}
