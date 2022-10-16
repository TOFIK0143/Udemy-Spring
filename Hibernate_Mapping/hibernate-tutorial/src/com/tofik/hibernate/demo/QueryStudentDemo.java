package com.tofik.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tofik.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory =  new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// start the transaction
			session.beginTransaction();
			
			// query student 
			List<Student> theStudents = session.createQuery("from Student").list();
			
			
			// display the students 
			displayStudents(theStudents);
		
			// query students: lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Maniyar'").list();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Doe");
			displayStudents(theStudents);
			
			// query students: lastName:'Maniyar' OR firstName='Datta'
			theStudents = 
					session.createQuery("from Student s where"
										+ " s.lastName='Maniyar' OR s.firstName='Datta'").list();
			
			// display the students
			System.out.println("\n\nStudents who have last name od Maniyar OR firstName Datta ");
			displayStudents(theStudents);
			
			// query students: where email LIKE '%tofik.com'
			theStudents = session.createQuery("from Student s where"
											+ " s.email LIKE '%tofik.com'").list();
			
			// display the students
			System.out.println("\n\nStudents who has email ends with tofik.com");
			displayStudents(theStudents);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
