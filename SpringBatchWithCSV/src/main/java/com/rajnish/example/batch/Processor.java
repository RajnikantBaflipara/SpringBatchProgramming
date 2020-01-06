package com.rajnish.example.batch;

import java.util.HashMap;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.rajnish.example.model.Test;

@Component
public class Processor implements ItemProcessor<Test, Test>{

	private static final HashMap<String, String> DEPT_NAMES=new HashMap<>();
	
	public Processor() {
		DEPT_NAMES.put("Pune", "411023");
		DEPT_NAMES.put("Pune", "411023");
		DEPT_NAMES.put("Surat", "394101");
	}
	@Override
	public Test process(Test test) throws Exception {
		// TODO Auto-generated method stub
		String  city=test.getCity();
		String pinCode=DEPT_NAMES.get(city);
		test.setCity(pinCode);
		return test;
	}

}
