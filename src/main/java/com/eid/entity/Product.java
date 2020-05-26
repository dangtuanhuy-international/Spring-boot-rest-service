package com.eid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")

public class Product {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

@Column(name = "name")
private String productName;

@Column(name = "details")
private String productDetails;

@Column(name = "address")
private String productAddress;

public Product(String productName, String productDetails, String productAddress) {
	super();
	this.productName = productName;
	this.productDetails = productDetails;
	this.productAddress = productAddress;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductDetails() {
	return productDetails;
}
public void setProductDetails(String productDetails) {
	this.productDetails = productDetails;
}
public String getProductAddress() {
	return productAddress;
}
public void setProductAddress(String productAddress) {
	this.productAddress = productAddress;
}

}
