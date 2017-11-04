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
import com.blog.model.Job;
import com.blog.registerDAO.JobInt;

@RestController
public class JobController
{
	@Autowired
	private JobInt jobDAO;
	
	@PostMapping("/jobInfo")
	public ResponseEntity<Job> addJobDetails(@RequestBody Job jobDetails)
	{
		jobDAO.addJobDetails(jobDetails);
		System.out.println(jobDetails.getCompanyName());
		return new ResponseEntity<Job>(jobDetails,HttpStatus.OK);
		
	}

	
	@GetMapping("/deleteJob")
	public ResponseEntity<Job> deleteblog(@RequestParam ("jobId") String jobId)
	{
		System.out.println(jobId);
		jobDAO.deleteJob(jobId);
		return new ResponseEntity<Job>(HttpStatus.OK);
	}

	
	
	
	
	@PostMapping("/editJob")
	public ResponseEntity<Job> editJob(@RequestBody Job job){
		jobDAO.editJob(job);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	
	
	
	
	
	
	@GetMapping("getJob/{jobId}")
	public ResponseEntity<Job> getBlog(@PathVariable ("jobId") String jobId)
	{
		System.out.println(jobId);
		Job job=jobDAO.getJob(jobId);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}

	@GetMapping("getAllJobs")
	public ResponseEntity<List<Job>> getJobs()
	{
		
		List<Job> jobs=jobDAO.getAllJobs();
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}
	
}
