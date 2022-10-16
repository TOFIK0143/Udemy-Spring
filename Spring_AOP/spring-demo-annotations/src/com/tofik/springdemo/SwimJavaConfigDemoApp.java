package com.tofik.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

				// read spring configuration file
				AnnotationConfigApplicationContext context = 
						new AnnotationConfigApplicationContext(SportConfig.class);
				
				// get the bean from spring container
				Coach theCoach = context.getBean("swimCoach", Coach.class);
				SwimCoach theSwimCoach = context.getBean("swimCoach", SwimCoach.class);
				
				// call a method on the bean
				System.out.println(theCoach.getDailyWorkout());
					
				// call method to get daily fortune
				System.out.println(theCoach.getDailyFortune());
				
				// call our new swim coach methods ... has a the props values injected 
				
				System.out.println("email: "+ theSwimCoach.getEmail());
				System.out.println("name: "+ theSwimCoach.getName());
				
				// close the context
				context.close();
				
	}

}
