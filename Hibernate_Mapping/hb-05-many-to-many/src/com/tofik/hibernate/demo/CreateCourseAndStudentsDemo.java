package com.tofik.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tofik.hibernate.demo.entity.Course;
import com.tofik.hibernate.demo.entity.Instructor;
import com.tofik.hibernate.demo.entity.InstructorDetail;
import com.tofik.hibernate.demo.entity.Review;
import com.tofik.hibernate.demo.entity.Student;


public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory =  new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// start the transaction
			session.beginTransaction();
			
			// create a transaction
			Course tempCourse = new Course("Pacman - How To Score One Million Points");
			
	
			// save the course
			System.out.println("\nSaving the course ...");
			session.save(tempCourse);
			System.out.println("Saved the course: " + tempCourse);
			
			// create the students
			Student tempStudent1 = new Student("Tofik", "Maniyar", "tofik2@tofik.com");
			Student tempStudent2 = new Student("Sanket", "Mane", "sanket3@tofik.com");
			Student tempStudent3 = new Student("Jeevan", "Sangave", "jeevan4@tofik.com");
			
			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			tempCourse.addStudent(tempStudent3);
			
			// save the students
			System.out.println("\nSaving students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			System.out.println("\nSaved students: " + tempCourse.getStudents());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}
