package com.product.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.product.pojo.Product;

public class ProductTest {

	public static void main(String[] args) {

		// type 1 
		//StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		//MetadataSources sources = new MetadataSources(registry);
		//Metadata metadata = sources.getMetadataBuilder().build();
		//SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

		// type 2

		Session session = HibernateUtil.getSession();
		//Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Product p = new Product(1, "Laptop", "dell");
		session.save(p);
		t.commit();

	}
}
