package com.example.springbootdbdemo.service;

import com.example.springbootdbdemo.beans.Profile;
import com.example.springbootdbdemo.dao.ProfileRepository;
import com.example.springbootdbdemo.exceptions.ProfileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileDao;

    @Transactional
    @Override
    public Profile storeProfile(Profile profile) {
        Profile cProfile = profileDao.save(profile);
        return cProfile;
    }

    @Override
    public List<Profile> fetchProfiles() {
        List<Profile> list = profileDao.findAll();
        return list;
    }

    @Override
    public Profile fetchProfile(int id) throws ProfileNotFoundException {
        Profile profile = profileDao.findById(id).orElse(null);
        if(profile == null){
            throw new ProfileNotFoundException("Profile with an id: " + id + "is not found!");
        }
        return profile;
    }
}
