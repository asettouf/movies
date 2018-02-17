package org.test.Connectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.test.Entities.Model;
import org.test.Entities.Score;

@Repository
public class MySQLManager {

	
	@Autowired
	private SessionFactory sessionFactory; // Spring to instantiate it

	public void createScoreHibernate(int scoreValue) {
		// Here we get a session from the Hibernate session factory
		Session session = sessionFactory.openSession();
		Score score = new Score(scoreValue);
		// Now we instruct it to start a transaction with the Database
		session.beginTransaction();
		// Save the new score
		session.save(score);
		// Commit the transaction so that it gets recorded
		session.getTransaction().commit();
	}

	public void createModelHibernate(Model model) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(model);
		session.getTransaction().commit();
		System.out.println("Everything worked fine!");

	}
	
//	public void getModelHibernate(Model model){
//		Session session = sessionFactory.openSession();
//		session.g(model);
//		session.getTransaction().commit();
//		System.out.println("Everything worked fine!");
//	}
	
	public void getModel(int id){
		System.out.println("In get Model with id" + id);
	}

}
