package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class AccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue
	private Integer accountId;

	@Column(unique = false, nullable = false, length = 100)
	private String accountNumber;

	// We will define the association here
	@OneToOne (mappedBy = "account")
	EmployeeEntity employee;
	
	
	
	
	

	public AccountEntity() {
		// TODO Auto-generated constructor stub
	}

	public AccountEntity(Integer accountId, String accountNumber, EmployeeEntity employee) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.employee = employee;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AccountEntity [accountId=" + accountId + ", accountNumber=" + accountNumber + ", employee=" + employee
				+ "]";
	}
	
	
	
}
