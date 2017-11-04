package com.blog.registerDAO;

import java.util.List;

import com.blog.model.Blog;

public interface BlogDaoInt 
{
	public boolean addBlog(Blog blog);
	public void deleteblog(String blogid);
	public void editBlog(Blog blog);
	public Blog getBlog(String blogId);
	public List<Blog> getAllBlogs();
	public List<Blog> waitingForApproval();

}

