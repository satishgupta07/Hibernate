package com.satishkumar06.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Student student1 = new Student();
		student1.setId(14134);
		student1.setName("Ankit Tiwari");
		student1.setCity("Kanpur");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Android");
		certificate.setDuration("2 months");
		
		student1.setCerti(certificate);
		
		Student student2 = new Student();
		student2.setId(1212);
		student2.setName("Amit Mishra");
		student2.setCity("Lucknow");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Hibernate");
		certificate1.setDuration("1.5 months");
		
		student2.setCerti(certificate1);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		//objects save:
		s.save(student1);
		s.save(student2);
		
		tx.commit();
		s.close(); 
		factory.close();

	}

}
