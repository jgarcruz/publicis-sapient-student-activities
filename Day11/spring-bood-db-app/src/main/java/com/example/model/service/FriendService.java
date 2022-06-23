package com.example.model.service;

import com.example.exceptions.ProfileNotFoundException;
import com.example.model.beans.Friend;
import com.example.model.beans.Profile;

public interface FriendService {
	// since Friend table must have profileIdRef we will pass profile id while adding a friend
	public Friend addFriend(int profileIdRef, Friend friend);
	public void removeFriend(int profileIdRef, Friend friend) throws ProfileNotFoundException;
	public void modFriendPhone(int profileIdRef, Friend friend, long phone) throws ProfileNotFoundException;
}
