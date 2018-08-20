package de.mavid.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryWrapper {

	private final SessionFactory sessionFactory;

	public SessionFactoryWrapper(final Class<?>... classes) {
		this.sessionFactory = this.createSessionFactory(classes);
	}

	private SessionFactory createSessionFactory(final Class<?>[] classes) {
		final Configuration configuration = new Configuration();
		configuration.configure(); // Reads hibernate.cfg.xml from classpath

		for (Class<?> c : classes) {
			configuration.addAnnotatedClass(c);
		}

		final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
}