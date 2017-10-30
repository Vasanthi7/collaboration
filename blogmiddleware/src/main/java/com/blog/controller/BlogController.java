package com.blog.controller;

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
	
	

}
