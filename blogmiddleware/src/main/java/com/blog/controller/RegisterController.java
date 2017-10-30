package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.model.RegistrationForm;
import com.blog.registerDAO.RegisterationInt;

@RestController
public class RegisterController {
	@Autowired
	private RegisterationInt rDao;
	
	@PostMapping("/registerUser")
	public ResponseEntity<RegistrationForm> registerUser(@RequestBody RegistrationForm register){
		rDao.registerUser(register);
		
		System.out.println(register.getEmailId());
				return new ResponseEntity<RegistrationForm>(register,HttpStatus.OK);		
			
		}

}