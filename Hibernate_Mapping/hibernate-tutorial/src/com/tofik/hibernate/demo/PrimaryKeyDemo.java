package com.tofik.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tofik.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
				SessionFactory factory =  new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
				
				// create session
				
				Session session = factory.getCurrentSession();
				
				try {
					// use the session object to save Java Object
					// create 3 students objects
					System.out.println("Creating new student object...");
					Student tempStudent1 =  new Student("Sanket", "Mane", "sanket@tofik.com");
					Student tempStudent2 =  new Student("Jeevan", "Sangave", "jeevan@tofik.com");
					Student tempStudent3 =  new Student("Datta", "Devangare", "datta@tofik.com");
					Student tempStudent4 =  new Student("Swapnil", "Waghmare", "swapnil@tofik.com");
					Student tempStudent5 =  new Student("Suraj", "Shinde", "suraj@tofik.com");
					
					// start the transaction
					session.beginTransaction();
					
					// save the student object
					System.out.println("Saving the student...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					session.save(tempStudent4);
					session.save(tempStudent5);
					
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
			}
	}
