package com.blog.registerDAO;

import com.blog.model.Blog;
import com.blog.model.Job;

public interface JobInt 
{
	boolean addJobDetails(Job jobDetails);
	public void deleteJob(String jobId);
	public void editJob(Job job);
	
	

}
