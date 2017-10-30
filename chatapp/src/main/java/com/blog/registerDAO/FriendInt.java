package com.blog.registerDAO;

import java.util.List;

import com.blog.model.Friend;
import com.blog.model.RegistrationForm;

public interface FriendInt 
{
	List<RegistrationForm> listOfSuggestedUsers(String firstName);
	void friendRequest(Friend friend);

}
