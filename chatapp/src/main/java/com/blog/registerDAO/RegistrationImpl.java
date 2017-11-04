package com.blog.registerDAO;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.internal.compile.CriteriaQueryTypeQueryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.model.RegistrationForm;

import oracle.net.aso.r;


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


	public RegistrationForm loginCheck(RegistrationForm registrationUser)
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from RegistrationForm where id = ? and password = ?");
		query.setString(0, registrationUser.getRegistrationId());
		query.setString(1,registrationUser.getPassword());
		registrationUser = (RegistrationForm)query.uniqueResult();
		return registrationUser;
	}
}
