package com.blog.registerDAO;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.model.Friend;
import com.blog.model.RegistrationForm;

@Repository("friendDao")
@Transactional
public class FriendImpl implements FriendInt {
	@Autowired
	private SessionFactory sessionFactory;

	public List<RegistrationForm> listOfSuggestedUsers(String firstName) 
	{
		Session session=sessionFactory.getCurrentSession();
		SQLQuery query=session.createSQLQuery("select * from RegistrationForm where firstName in "
							+ "(select firstName from RegistrationForm where firstName!=? minus "
							+ "(select fromId from Friend where toId=? "
							+ "union select toId from Friend where fromId=?)"
							+ ")");
		query.setString(0, "firstName");
		query.setString(1, "firstName");
		query.setString(2, "firstName");
		query.addEntity(RegistrationForm.class);
		List<RegistrationForm> SuggestedUsers=query.list();
		
		return SuggestedUsers ;
	}
	
	public void friendRequest(Friend friend)
	
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(friend);
	}
	

}
