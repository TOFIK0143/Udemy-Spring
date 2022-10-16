package com.tofik.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

				// read spring configuration file
				AnnotationConfigApplicationContext context = 
						new AnnotationConfigApplicationContext(SportConfig.class);
				
				// get the bean from spring container
				Coach theCoach = context.getBean("tennisCoach", Coach.class);
				Coach theKhoKhoCoach = context.getBean("KhoCoach", Coach.class);
				
				// call a method on the bean
				System.out.println(theCoach.getDailyWorkout());
				System.out.println(theKhoKhoCoach.getDailyWorkout());
					
				// call method to get daily fortune
				System.out.println(theCoach.getDailyFortune());
				
				// close the context
				context.close();
				
	}

}
