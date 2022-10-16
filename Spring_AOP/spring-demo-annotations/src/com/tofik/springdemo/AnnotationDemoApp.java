package com.tofik.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

				// read spring configuration file
				ClassPathXmlApplicationContext context = 
						new ClassPathXmlApplicationContext("applicationContext.xml");
				
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
