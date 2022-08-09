package com.product.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {

	@Id
	@Column
	private Integer productId;

	@Column
	private String name;
	
	@Column
	private String description;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer productId, String name, String description) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", description=" + description + "]";
	}
	
	
	
}
