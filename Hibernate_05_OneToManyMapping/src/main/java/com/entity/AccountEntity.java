package com.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { 
		@UniqueConstraint(columnNames = "accountId") })
public class AccountEntity implements Serializable {
	private static final long serialVersionUID = -6790693372846798580L;

	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false)
	private Integer accountId;

	@Column(unique = true, nullable = false, length = 100)
	private String accountNumber;

	@ManyToOne
	private EmployeeEntity employee;
	
	
	
	// Constructor and setter getter

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

	@Override
	public int hashCode() {
		return Objects.hash(accountId, accountNumber, employee);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountEntity other = (AccountEntity) obj;
		return Objects.equals(accountId, other.accountId) && Objects.equals(accountNumber, other.accountNumber)
				&& Objects.equals(employee, other.employee);
	}

}
