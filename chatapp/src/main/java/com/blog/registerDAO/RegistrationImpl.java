package com.blog.registerDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.model.RegistrationForm;


@Repository("rDao")
@Transactional
public class RegistrationImpl implements RegisterationInt
{
	
	@Autowired
	private SessionFactory sessionFactory;


	public boolean registerUser(RegistrationForm registrationUser)
	{

		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.save(registrationUser);
		return true;
	}catch(Exception e)
		{
		System.out.println(e.getMessage());
		return false;
		

}
	}
}
