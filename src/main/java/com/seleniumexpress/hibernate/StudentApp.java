package com.seleniumexpress.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.seleniumexpress.models.Actor;
import com.seleniumexpress.models.Movie;
import com.seleniumexpress.utils.HibernateUtils;

/**
 * Hello world!
 *
 */
public class StudentApp {

	private static Session session = null;

	public static void main(String[] args) {

		// 1. create configuration
		// 2. create session factory
		// 3. initialize the session object

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();

		Transaction transaction = session.getTransaction();

		transaction.begin();

		Actor actor = new Actor();
		actor.setName("MADARCHOD");

		Movie movie = new Movie();
		movie.setName("GAND MARAO");

		actor.addMovie(movie);

		session.persist(actor);

		transaction.commit();

		session.close();
		sessionFactory.close();

	}

}
