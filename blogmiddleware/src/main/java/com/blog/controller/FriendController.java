package com.blog.controller;

import java.util.List;

import javax.servlet.Registration;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.model.Friend;
import com.blog.model.RegistrationForm;
import com.blog.registerDAO.FriendInt;

@RestController
public class FriendController
{
	@Autowired
	private FriendInt friendDao;
	
	@PostMapping("/suggestFriend")
	public ResponseEntity<?> listOfSuggestedUsers(@RequestBody String firstname)
	{
		List<RegistrationForm> suggestedUsers=friendDao.listOfSuggestedUsers(firstname);
		return new ResponseEntity<List<RegistrationForm>>(suggestedUsers,HttpStatus.OK);		

}
	@PostMapping("/reqFriend")
	public ResponseEntity<?> friendRequest(@RequestBody Friend friend)
	{
			friendDao.friendRequest(friend);
		System.out.println(friend.getFromId());
				return new ResponseEntity<Friend>(friend,HttpStatus.OK);		
			
		}
	}

	

	
	
