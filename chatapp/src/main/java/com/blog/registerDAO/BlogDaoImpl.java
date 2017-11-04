package com.blog.registerDAO;

import java.util.List;

import org.hibernate.Query;
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



				public Blog getBlog(String blogId)
				{
					Session session=sessionFactory.getCurrentSession();
					Blog blog=(Blog)session.get(Blog.class, blogId);
					blog.setBlogApproval("true");
					session.save(blog);
					return blog;
					
				}
				
				public List<Blog> getAllBlogs()
				{
					Session session=sessionFactory.getCurrentSession();
					Query query=session.createQuery("from Blog");
					
					return query.getResultList();
					
				}



				public List<Blog> waitingForApproval()
				{
					Session session=sessionFactory.getCurrentSession();
					Query query=session.createQuery("from Blog where blogApproval='false'");
					return query.getResultList();
				}


				
				

					
					/*public Blog updateBlogApproval(Blog blog) {
						Session session=sessionFactory.getCurrentSession();
						Query query=session.createQuery("from Blog where blogApproval = ?");
						query.setString(0, blog.getBlogApproval());
						session.update(blog);
						 return  blog=(Blog)query.uniqueResult();
					}

*/
			
				
				
				
		}
				
		
			
			
		
		
		
		


