package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.satishkumar06.Hibernate.Certificate;
import com.satishkumar06.Hibernate.Student;

public class StateDemo {
	
	public static void main(String[] args) {
		
		//Practical of Hibernate Object States
		//Transient
		//Persistent
		//Detached
		//Removed
		System.out.println("Example : ");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//Creating Student Object
		Student student = new Student();
		student.setId(198);
		student.setName("Peter");
		student.setCity("ABC");
		student.setCerti(new Certificate("Java Hibernate Course", "2 months"));
		//student : Transient
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(student);
		//student : Persistent -> session, database
		student.setName("John");
		
		tx.commit();
		
		session.close();
		//studnet : Datched  
		student.setName("Sachin");
		
		System.out.println(student);
		factory.close();
	}

}
