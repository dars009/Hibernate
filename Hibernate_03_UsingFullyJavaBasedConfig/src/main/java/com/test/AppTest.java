package com.test;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Student;
import com.utils.HibernateUtil;
public class AppTest {
    public static void main(String[] args) {
       
    	// transient state
    	Student student = new Student("urvi", "d", "urvi@gmail.com");
        Student student1 = new Student("kajal", "k", "kajal@gmail.com");
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            
            // persistent state 
            // save the student objects
            session.save(student);
            session.save(student1);
                   
            //--------------------------------------------
            // commit transaction
            transaction.commit();
            
       // detached state
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
               
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> students = session.createQuery("from Student", Student.class).list();
            
            students.forEach(s->System.out.println("FirstName >>>"+ s.getFirstName() +   "LastName>>>"  + s.getLastName() +  "Email>>>" +   s.getEmail()));
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
