package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Customer;
import com.entity.Vendor;
import com.utils.HibernateUtil;

public class AppTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Vendor ven = new Vendor();
		ven.setV_id(101);
		ven.setName("Darshit");

		Customer c = new Customer();
		c.setC_id(201);
		c.setName("Mohan");
		c.setV(ven);

		Customer c2 = new Customer();
		c2.setC_id(202);
		c2.setName("Rohan");
		c2.setV(ven);

		session.save(c);
		session.save(c2);
		
		session.getTransaction().commit();
		session.close();

		System.out.println("saved successfuly!!");

	}
}