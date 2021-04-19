package com.NovusBank.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.NovusBank.entity.Account;
//import com.NovusBank.entity.Account;
import com.NovusBank.entity.User;

public class DatabaseController {

	SessionFactory sf;
	
	public DatabaseController(){
	
	Configuration con = new Configuration()
						.addAnnotatedClass(Account.class)
						.addAnnotatedClass(User.class)
						.configure();
	  
	StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	   
	sf = con.buildSessionFactory(reg);
	
	}
	
	public void addUser(User user) {

		Account initialAccount = new Account();
		initialAccount.setUser(user);
		
		try {
			Session session = sf.openSession(); 
			Transaction t = session.beginTransaction(); 
			session.save(user);  
			session.save(initialAccount);
		    t.commit();
		    session.close();		    
		}
		//Re-creates account if initialAccount.AccountNumber is already in the database
		//low chance of it happening twice so quick fix for now
		catch (Exception e) {
			System.out.println("Error adding user to database, probably because accountNumber already in use : " + e);
			
			initialAccount = new Account();
			
			Session session = sf.openSession(); 
			Transaction t = session.beginTransaction(); 
			session.save(user);  
			session.save(initialAccount);
		    t.commit();
		}
	}
	
	public User getUser(String email) {
		
		Session session = sf.openSession();
		User tempUser = session.get(User.class, email);
		
		return tempUser;
	}
	
	public void newAccount(String email) {
		Session session = sf.openSession();
		User tempUser = session.get(User.class, email);
		
		Account tempAccount = new Account();
		tempAccount.setUser(tempUser);
		
		try {
			session = sf.openSession(); 
			Transaction t = session.beginTransaction();  
			session.save(tempAccount);
		    t.commit();
		    session.close();		    
		}
		//Re-creates account if initialAccount.AccountNumber is already in the database
		//low chance of it happening twice so quick fix for now
		catch (Exception e) {
			System.out.println("Error adding Account to database, probably because accountNumber already in use : " + e);
			
			tempAccount = new Account();
			tempAccount.setUser(tempUser);
			
			session = sf.openSession(); 
			Transaction t = session.beginTransaction(); 
 
			session.save(tempAccount);
		    t.commit();
		}
		
	}
	
}








