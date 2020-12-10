package com.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.satishkumar06.Hibernate.Student;

public class HQLExample {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		
		//HQL
		//Syntax : 
//		String query = "from Student where city='ABC'";
//		String query = "from Student where city=:x";
		String query = "from Student as s where s.city=:x and s.name=:n";
		
		Query q = s.createQuery(query);
		
//		q.setParameter("x", "ABC");
		q.setParameter("x", "ABC");
		q.setParameter("n", "John");
		
		//single -> (Unique)
		//multiple -> List
		List<Student> list = q.list();
		
		for(Student student : list) {
			System.out.println(student.getName()+" : "+student.getCerti());
		}
		
		s.close();
		factory.close();
	}
}
