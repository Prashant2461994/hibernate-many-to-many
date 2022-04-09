package com.seleniumexpress.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.seleniumexpress.models.Actor;
import com.seleniumexpress.models.Movie;

public class HibernateUtils {

	private HibernateUtils() {

	}

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {

		try {
			if (sessionFactory == null) {
				Configuration cfg = new Configuration();
				cfg.configure("hibernate.cfg.xml");
				cfg.addAnnotatedClass(Movie.class);
				cfg.addAnnotatedClass(Actor.class);
				sessionFactory = cfg.buildSessionFactory();
			}
		} catch (Exception e) {
			System.out.print("Session Factory Object can not be created :: " + e.getMessage());
			e.printStackTrace();
		}

		return sessionFactory;
	}
}
