package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {
		
		 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 
		 Question q1 = new Question();
		 q1.setQuesId(121);
		 q1.setQuestion("What is Java ?");
		 
		 Answer a1 = new Answer();
		 a1.setAnsId(221);
		 a1.setAnswer("Java is programming language");
		 a1.setQuestion(q1);
		 
		 q1.setAnswer(a1);
		 
		 Question q2 = new Question();
		 q2.setQuesId(122);
		 q2.setQuestion("What is Collection Framework ?");
		 
		 Answer a2 = new Answer();
		 a2.setAnsId(222);
		 a2.setAnswer("API to work with objects in Java");
		 a2.setQuestion(q2);
		 
		 q2.setAnswer(a2);
		 
		 Session session = factory.openSession();

		 Transaction tx = session.beginTransaction();
		 
		 session.save(q1);
		 session.save(q2);
		 session.save(a1);
		 session.save(a2);
		 
		 tx.commit();
		 
		 // fetching........
		 Question newQ = (Question) session.get(Question.class,121);
		 System.out.println(newQ.getQuestion());
		 System.out.println(newQ.getAnswer().getAnswer());
		 
		 session.close();
		 factory.close();
	}

}
