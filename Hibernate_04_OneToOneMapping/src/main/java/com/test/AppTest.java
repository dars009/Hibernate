package com.test;

import org.hibernate.Session;

import com.entity.AccountEntity;
import com.entity.EmployeeEntity;
import com.utils.HibernateUtil;

public class AppTest {

	public static void main(String[] args) {

		Session sessionOne = HibernateUtil.getSessionFactory().openSession();
		sessionOne.beginTransaction();

		// Create new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setFirstName("Darshit");
		emp.setLastName("Patel");

		// Create new Account object
		AccountEntity acc = new AccountEntity();
		acc.setAccountNumber("12310100133486");
		
		emp.setAccount(acc);
		//acc.setEmployee(emp);

		sessionOne.save(acc);
		sessionOne.save(emp);
		sessionOne.getTransaction().commit();

		Integer genEmpId = emp.getEmployeeId();
		Integer genAccId = acc.getAccountId();

		Session sessionTwo = HibernateUtil.getSessionFactory().openSession();
		sessionTwo.beginTransaction();
		EmployeeEntity employee = (EmployeeEntity) sessionTwo.get(EmployeeEntity.class, genEmpId);
		AccountEntity account = (AccountEntity) sessionTwo.get(AccountEntity.class, genAccId);

		System.out.println(employee.getEmployeeId());
		System.out.println(employee.getAccount().getAccountNumber());
		System.out.println(account.getAccountId());
		System.out.println(account.getEmployee().getEmployeeId());

		sessionOne.close();
		sessionTwo.close();
	}
}
