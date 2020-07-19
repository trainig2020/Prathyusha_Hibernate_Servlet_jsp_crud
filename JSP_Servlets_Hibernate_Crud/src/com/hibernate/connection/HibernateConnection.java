package com.hibernate.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {

	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		
		return sessionFactory;
		
		
	}
}