package com.rajnish.example.controller;

import java.util.HashMap;
import java.util.Map;

import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.JobExecution;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/load")
public class LoadController {

	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	@GetMapping
	public org.springframework.batch.core.BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException{
		Map<String, JobParameter> maps=new HashMap<>();
		maps.put("time", new JobParameter(System.currentTimeMillis()));
		//JobParameter parameters=new JobParameter(maps);
		JobParameters parameters=new JobParameters(maps);
		org.springframework.batch.core.JobExecution jobExecution=jobLauncher.run(job, parameters);
		
		System.out.println("Batch is Running..");
		while(jobExecution.isRunning()){
			System.out.println("...");
		}
		
		return jobExecution.getStatus();
	}
}
