package com.example.springbootdbdemo.service;

import com.example.springbootdbdemo.beans.Profile;
import com.example.springbootdbdemo.exceptions.ProfileNotFoundException;

import java.util.List;

public interface ProfileService {
    public Profile storeProfile(Profile profile);
    public List<Profile> fetchProfiles();
    public Profile fetchProfile(int id) throws ProfileNotFoundException;
}
