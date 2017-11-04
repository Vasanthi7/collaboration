package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.model.Blog;
import com.blog.registerDAO.BlogDaoInt;

@RestController
public class BlogController 
{
	@Autowired
	private BlogDaoInt blogDao;
	
	@PostMapping("/blogInfo")
	public ResponseEntity<Blog> addBlog(@RequestBody Blog blog){
		blogDao.addBlog(blog);
		
		System.out.println(blog.getBlogid());
				return new ResponseEntity<Blog>(blog,HttpStatus.OK);		
			
		}
	
	
	
	@GetMapping("/deleteBlog")
	public ResponseEntity<Blog> deleteblog(@RequestParam ("blogid") String blogid)
	{
		System.out.println(blogid);
		blogDao.deleteblog(blogid);
		return new ResponseEntity<Blog>(HttpStatus.OK);
	}
	
	
	
	@PostMapping("/reqeditblog")
	public ResponseEntity<Blog> editBlog(@RequestBody Blog blog){
		blogDao.editBlog(blog);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	
	
	@GetMapping("getblog/{blogId}")
	public ResponseEntity<Blog> getBlog(@PathVariable ("blogId") String blogId)
	{
		System.out.println(blogId);
		Blog blog=blogDao.getBlog(blogId);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}

	@GetMapping("getAllBlogs")
	public ResponseEntity<List<Blog>> getBlogs()
	{
		
		List<Blog> blogs=blogDao.getAllBlogs();
		return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
	}
	
	
	
	@GetMapping("getblogs")
	public ResponseEntity<List<Blog>> getBlogApproval(){
		List<Blog> blogs=blogDao.waitingForApproval();
		return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
	}
	
	
	
	/*@PostMapping("/Approved") 
	public ResponseEntity<Blog> updateBlogApproval(@RequestBody Blog blog)
	{
		 blogDao.updateBlogApproval(blog);
		 return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
*/}

