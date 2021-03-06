package com.blog.registerDAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.model.Blog;
import com.blog.model.Job;

@Repository("jobDAO")
@Transactional
public class JobImpl implements JobInt 
{
	@Autowired
	private SessionFactory sessionFactory;

	

	public boolean addJobDetails(Job jobDetails)
	{
		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.save(jobDetails);
			return true;
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		return false;
		
	}

}



	public void deleteJob(String jobId)
	{

		Session session=sessionFactory.getCurrentSession();
		Job job=session.get(Job.class,jobId);
		session.delete(job);
		
	}



		

		public void editJob(Job job) {

			Session session = sessionFactory.getCurrentSession();
			session.update(job);
			
		}
		
		
		
		
		
		
		
		

		public Job getJob(String jobId)
		{
			Session session=sessionFactory.getCurrentSession();
			Job job=(Job)session.get(Job.class, jobId);
			return job;
			
		}
		
		public List<Job> getAllJobs()
		{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Job");
			
			return query.getResultList();
			
		}
		
		
	}

