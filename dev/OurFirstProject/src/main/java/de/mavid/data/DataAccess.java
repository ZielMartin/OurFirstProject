package de.mavid.data;

import java.io.File;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DataAccess {
	private static DataAccess instance;
	private SessionFactoryWrapper sessionFactoryWrapper;

	private DataAccess() {
		sessionFactoryWrapper = new SessionFactoryWrapper(de.mavid.data.Entities.Territory.class);
	}

	public static DataAccess getInstance() {
		if (instance == null) {
			instance = new DataAccess();
		}
		return instance;
	}

	public static void destroy() {
		instance.sessionFactoryWrapper.getSessionFactory().close();
	}

	public void save(Object object) {
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactoryWrapper.getSessionFactory().openSession();
			tx = session.beginTransaction();

			// Saving to the database
			session.save(object);

			// Committing the change in the database.
			session.flush();
			tx.commit();

		} catch (Exception ex) {
			ex.printStackTrace();

			// Rolling back the changes to make the data consistent in case of any failure
			// in between multiple database write operations.
			tx.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getAll(Class<T> entityType) {
		Session session = sessionFactoryWrapper.getSessionFactory().openSession();
		List<T> list = session.createQuery("from " + entityType.getName()).list();
		session.close();
		return list;

	}

	public <T> T getOne(Class<T> entityType, Serializable id) {
		Session session = sessionFactoryWrapper.getSessionFactory().openSession();
		T item = session.get(entityType, id);
		session.close();
		return item;
	}

}
