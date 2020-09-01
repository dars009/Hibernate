package com.test;

import org.hibernate.Session;

import com.entity.Student;
import com.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class AppTest {

	@SuppressWarnings({ "deprecation", "unchecked" })
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

		System.out.println("################ BETWEEN #####################");

		Criteria crit7 = session.createCriteria(Student.class);
		crit7.add(Restrictions.between("rollNumber", 12, 15));
		List<Student> stud7 = crit7.list();
		for (Student student : stud7) {
			System.out.println(student);
		}

		System.out.println("################ projection #####################");

		Criteria crit8 = session.createCriteria(Student.class);
        Projection projection1 = Projections.max("rollNumber");
        Projection projection2 = Projections.property("studentName");
        
        
        ProjectionList pList = Projections.projectionList();
        pList.add(projection1);
        pList.add(projection2);
        crit8.setProjection(pList);
        
        List list2 = crit8.list();

        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            Object[] obj = (Object[]) it2.next();
            System.out.println("Roll No : " + obj[0]+" Name : "+obj[1]);
        }
		session.getTransaction().commit();
		session.close();
	}
}