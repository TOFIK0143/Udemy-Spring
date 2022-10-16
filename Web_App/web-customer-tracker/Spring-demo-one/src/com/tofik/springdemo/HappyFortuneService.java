package com.tofik.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Toaday is your lucky day!";
	}

}
