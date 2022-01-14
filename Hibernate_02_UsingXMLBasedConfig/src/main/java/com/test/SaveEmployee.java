package com.test;

import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;
import com.utils.HibernateUtil;

public class SaveEmployee {

	public static void main(String[] args) {

		//SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		Employee employee = new Employee("Darshit33", "Rabadiya33", 100);
		//Integer employeeID = (Integer) session.save(employee);
		session.persist(employee);
		tx.commit();
		
		Employee emp1 = new Employee("Ram33","Ram33",110);
		//session.save(emp1);
		session.persist(emp1);
		/*
		 * SaveEmployee ME = new SaveEmployee(); Add few employee records in database
		 * Integer empID1 = ME.addEmployee("Darshit", "Rabadiya", 1000); Integer empID2
		 * = ME.addEmployee("Tejas", "T", 5000); Integer empID3 =
		 * ME.addEmployee("Mrunal", "M", 10000);
		 */

	}
}