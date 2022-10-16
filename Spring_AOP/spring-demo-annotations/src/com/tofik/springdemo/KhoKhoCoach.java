package com.tofik.springdemo;

import org.springframework.stereotype.Component;

@Component("KhoCoach")
public class KhoKhoCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		
		return "Run as fast as the deer!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
