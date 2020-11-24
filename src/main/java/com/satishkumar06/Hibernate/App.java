package com.satishkumar06.Hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started.." );
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        //Creating Student
        Student st = new Student();
        st.setId(109);
        st.setName("Mahender Singh Dhoni");
        st.setCity("Ranchi");
        
        System.out.println(st);
        
        //Creating Object of Address-Class
        Address ad = new Address();
        ad.setStreet("Street2");
        ad.setCity("DELHI");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);
        
        //Reading Image
        FileInputStream fis = new FileInputStream("src/main/java/satish.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(st);
        session.save(ad);
        
        tx.commit();
        
        session.close();
        
        System.out.println("Done..");
    }
}
