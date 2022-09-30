package com.tofik.springdemo;

public class MyApp {

	public static void main(String[] args) {
		
		//create the object
		Coach theBaseballCoach = new BaseballCoach();
		Coach theTrackCoach = new TrackCoach();
	
		//Use the object
		System.out.println(theBaseballCoach.getDailyWorkout());
		System.out.println(theTrackCoach.getDailyWorkout());
	}

}
