package com.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		
		System.out.println("_________________________________________________________");
		
		Transaction tx = s.beginTransaction();
		
		//delete query
//		Query q2 = s.createQuery("delete from Student where city=:c");
//		
//		q2.setParameter("c", "ABC");
//		
//		int r = q2.executeUpdate();
//		
//		System.out.println("Deleted : ");
//		System.out.println(r);
		
		
		//update query
		Query q3 = s.createQuery("update Student set city=:c where name=:n");
		q3.setParameter("c", "New Delhi");
		q3.setParameter("n", "Satish Kumar Gupta");
		
		int r = q3.executeUpdate();
		System.out.println(r + " objects updated");
		
		tx.commit();
		
		s.close();
		factory.close();
	}
}
