package com.satishkumar06.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		
		// get, load
		
		 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 Session session = factory.openSession();
		 
		 //get-student:106
		 Student student = (Student)session.get(Student.class, 106);
		 System.out.println(student);
		 
		 //load-address:2
		 Address ad = (Address)session.load(Address.class, 2);
		 System.out.println(ad.getStreet()+" : "+ad.getCity());
		 
		 session.close();
		 factory.close();

	}

}
