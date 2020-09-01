package com.test;

import org.hibernate.Session;

import com.entity.Student;
import com.utils.HibernateUtil;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import java.util.List;

public class AddData {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// Add data in student
		
		Student s1= new Student(1,"Darshit",11,"JAVA");
		Student s2= new Student(2,"Sandeep",12,"JAVA");
		Student s3= new Student(3,"Ruchit",13,"J2EE");
		Student s4= new Student(4,"Ravi",14,"Python");
		Student s5= new Student(5,"Amit",15,"C");
		Student s6= new Student(6,"Bhagvat",16,"Selenium");
		Student s7= new Student(7,"Abhishek",17,"Purl");
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(s5);
		session.save(s6);
		session.save(s7);
		//session.getTransaction().commit();
		
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("studentName", "Darshit"));

		List<Student> students = criteria.list();

		for (Student student : students) {
			System.out.println(student);
		}
		
		
		session.getTransaction().commit();
		session.close();
	}
}