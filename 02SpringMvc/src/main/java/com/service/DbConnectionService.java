package com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;



@Service
@Scope("prototype")
public class DbConnectionService {

	public Session getSession() {
		
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session =sessionFactory.openSession();
		return session;
	}
	
	
	
}
