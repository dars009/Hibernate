package com.test;

import org.hibernate.Session;

import com.entity.Student;
import com.utils.HibernateUtil;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class AppTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("studentName", "Darshit"));
		List<Student> students = criteria.list();
		for (Student student : students) {
			System.out.println(student);
		}

		System.out.println("###############################################");

		Criteria crit1 = session.createCriteria(Student.class);
		crit1.add(Restrictions.ne("studentName", "Darshit"));
		List<Student> stud1 = crit1.list();
		for (Student student : stud1) {
			System.out.println(student);
		}

		System.out.println("###############################################");

		Criteria crit2 = session.createCriteria(Student.class);
		crit2.add(Restrictions.gt("rollNumber", 12));
		List<Student> stud2 = crit2.list();
		for (Student student : stud2) {
			System.out.println(student);
		}

		System.out.println("###############################################");

		Criteria crit3 = session.createCriteria(Student.class);
		crit3.add(Restrictions.lt("rollNumber", 12));
		List<Student> stud3 = crit3.list();
		for (Student student : stud3) {
			System.out.println(student);
		}

		System.out.println("###############################################");

		Criteria crit4 = session.createCriteria(Student.class);
		crit4.add(Restrictions.gt("rollNumber", 11));
		crit4.add(Restrictions.ilike("course", "JA%", MatchMode.ANYWHERE));
		List<Student> stud4 = crit4.list();
		for (Student student : stud4) {
			System.out.println(student);
		}

		System.out.println("###############################################");

		Criteria crit5 = session.createCriteria(Student.class);
		crit5.addOrder(Order.desc("studentName"));
		List<Student> stud = crit5.list();
		for (Student student : stud) {
			System.out.println(student);
		}
		
		System.out.println("###############################################");
		
		Criteria crit6 = session.createCriteria(Student.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.max("rollNumber"));
		projList.add(Projections.min("rollNumber"));
		projList.add(Projections.avg("rollNumber"));
		crit6.setProjection(projList);
		
		List<Student> results = crit6.list();
		
		for (Student student : results) {
			System.out.println(student);
		}
		

		session.getTransaction().commit();
		session.close();
	}
}