package com.example.springbootdbdemo.dao;

import com.example.springbootdbdemo.beans.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
