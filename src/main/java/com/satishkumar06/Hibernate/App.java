package com.satishkumar06.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started.." );
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        Student st = new Student();
        st.setId(106);
        st.setName("Durgesh Tiwari");
        st.setCity("Lucknow");
        
        System.out.println(st);
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(st);
        
        tx.commit();
        
        session.close();
    }
}
