package com.mapping;

//import java.util.ArrayList;
//import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {
		
		 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 
//		 Question q1 = new Question();
//		 q1.setQuesId(131);
//		 q1.setQuestion("What is Java ?");
//		 
//		 Answer a1 = new Answer();
//		 a1.setAnsId(231);
//		 a1.setAnswer("Java is programming language");
//		 a1.setQuestion(q1);
//
//		 Answer a2 = new Answer();
//		 a2.setAnsId(331);
//		 a2.setAnswer("With the help of java we can create software");
//		 a2.setQuestion(q1);
//		 
//		 Answer a3 = new Answer();
//		 a3.setAnsId(431);
//		 a3.setAnswer("Java has different type of frameworks.");
//		 a3.setQuestion(q1);
		 
//		 List<Answer> list = new ArrayList<Answer>();
//		 list.add(a1);
//		 list.add(a2);
//		 list.add(a3);
//		 
//		 q1.setAnswers(list);
		 
		 Session session = factory.openSession();

		 Transaction tx = session.beginTransaction();
	
//		 //save
//		 session.save(q1);
//		 session.save(a1);
//		 session.save(a2);
//		 session.save(a3);
		 
		 Question q = session.get(Question.class, 131);
		 
		 System.out.println(q.getQuesId());
		 System.out.println(q.getQuestion());

		 System.out.println(q.getAnswers().size());
		 
		 tx.commit();
		 
		 session.close();
		 factory.close();
	}

}
