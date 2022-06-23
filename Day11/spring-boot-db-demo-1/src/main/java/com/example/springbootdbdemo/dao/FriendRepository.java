package com.example.springbootdbdemo.dao;

import com.example.springbootdbdemo.beans.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
    @Query("select f from Friend f where profileIDRef = ?1")
    public List<Friend> getFriendsFromProfile(int profileId);
}
