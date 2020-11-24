package com.satishkumar06.Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started.." );
        
//        Configuration cfg = new Configuration();
//        cfg.configure();
//        SessionFactory factory = cfg.buildSessionFactory();
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        System.out.println(factory);
        
        System.out.println(factory.isClosed());
    }
}
