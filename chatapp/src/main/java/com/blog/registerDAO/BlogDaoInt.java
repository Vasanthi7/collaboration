package com.blog.registerDAO;

import com.blog.model.Blog;

public interface BlogDaoInt 
{
	public boolean addBlog(Blog blog);
	public void deleteblog(String blogid);
	public void editBlog(Blog blog);
	
}

