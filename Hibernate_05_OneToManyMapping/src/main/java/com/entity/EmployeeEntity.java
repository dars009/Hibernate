package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { 
		@UniqueConstraint(columnNames = "employeeId"),
		@UniqueConstraint(columnNames = "email") })
public class EmployeeEntity implements Serializable {

	private static final long serialVersionUID = -1798070786993154676L;

	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false)
	private Integer employeeId;

	@Column(unique = true, nullable = false, length = 100)
	private String email;

	@Column(unique = false, nullable = false, length = 100)
	private String firstName;

	@Column(unique = false, nullable = false, length = 100)
	private String lastName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeId")
	private Set<AccountEntity> accounts;
	
	
	// Constructor and setter getter
	
	
	public EmployeeEntity() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeEntity(Integer employeeId, String email, String firstName, String lastName,
			Set<AccountEntity> accounts) {
		super();
		this.employeeId = employeeId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accounts = accounts;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<AccountEntity> accounts) {
		this.accounts = accounts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [employeeId=" + employeeId + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", accounts=" + accounts + "]";
	}
	
}
