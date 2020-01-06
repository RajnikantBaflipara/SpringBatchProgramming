package com.rajnish.example.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rajnish.example.model.Test;
import com.rajnish.example.repository.TestRepository;

@Component
public class DbWriter implements ItemWriter<Test>{

	@Autowired
	TestRepository testRepository;
	
	@Override
	public void write(List<? extends Test> test) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Data Saved for user : "+ test);
		testRepository.save(test);
	}

}
