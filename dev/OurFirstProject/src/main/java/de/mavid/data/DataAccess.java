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
	private SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;

	private DataAccess() {
		
		//Configuration config = new Configuration().configure();
		//ServiceRegistry servReg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		//SessionFactory factory = config.buildSessionFactory(servReg);
		
		
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(de.mavid.data.Entities.Territory.class);
			configuration.configure();

			Properties properties = configuration.getProperties();

			this.serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();
			this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble
			// building the SessionFactory so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	public static DataAccess getInstance() {
		if (instance == null) {
			instance = new DataAccess();
		}
		return instance;
	}

	public void save(Object object) {
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
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

	public <T> List<T> getAll(Class<T> entityType) {
		Session session = sessionFactory.openSession();
		List<T> list = session.createQuery("from " + entityType.getName()).list();
		session.close();
		return list;

	}

	public <T> T getOne(Class<T> entityType, Serializable id) {
		Session session = sessionFactory.openSession();
		T item = session.get(entityType, id);
		session.close();
		return item;
	}

}
