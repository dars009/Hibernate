package com.test;

import org.hibernate.Session;

import com.entity.AccountEntity;
import com.entity.EmployeeEntity;
import com.utils.HibernateUtil;

public class AppTest {

	public static EmployeeEntity addEmployee(String fName, String lName, String acNo) {
		Session sessionOne = HibernateUtil.getSessionFactory().openSession();
		sessionOne.beginTransaction();
		// Create new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setFirstName(fName);
		emp.setLastName(lName);
		// Create new Account object for add it in to employee
		AccountEntity acc = new AccountEntity();
		acc.setAccountNumber(acNo);
		emp.setAccount(acc);
		// Save data in to a database here it will fire insert query
		sessionOne.save(acc);
		sessionOne.save(emp);
		// data will store permanently in to database by using commit
		sessionOne.getTransaction().commit();
		// sessionOne.close();
		return sessionOne.get(EmployeeEntity.class, emp.getEmployeeId());
	}

	public static void main(String[] args) {

		EmployeeEntity employeeData = addEmployee("Ram", "Ram", "1234567890");
		System.out.println(employeeData);

	}
}
