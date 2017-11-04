package com.blog.registerDAO;

import com.blog.model.RegistrationForm;

public interface RegisterationInt 
{

	 public boolean registerUser(RegistrationForm registrationUser);
	 public RegistrationForm loginCheck(RegistrationForm registrationUser);


}
