package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "custo")
public class Customer {
	@Id
	@Column(name = "cust_id")
	private int c_id;
	
	@Column(name = "cust_name")
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "v_id", referencedColumnName = "vend_id")
	private Vendor v;

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vendor getV() {
		return v;
	}

	public void setV(Vendor v) {
		this.v = v;
	}
}