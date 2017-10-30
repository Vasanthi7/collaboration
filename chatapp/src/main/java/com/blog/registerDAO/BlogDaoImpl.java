package com.blog.registerDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.model.Blog;

@Repository("blogDao")
@Transactional
public class BlogDaoImpl implements BlogDaoInt {

	
		@Autowired
		private SessionFactory sessionFactory;

		public boolean addBlog(Blog blog) {
			Session session=sessionFactory.getCurrentSession();
			 try{
				 session.save(blog);
				 return true;
			 }catch(Exception e)
			 {
				 System.out.println(e.getMessage());
				 return false;
			 }
	}

			

			public void deleteblog(String blogid)
			{
				Session session=sessionFactory.getCurrentSession();
				Blog blog=session.get(Blog.class,blogid);
				session.delete(blog);
				
				
			}



			
				
				public void editBlog(Blog blog) {

					Session session = sessionFactory.getCurrentSession();
					session.update(blog);
					
				}
				
		}
			
			
		
		
		
		


