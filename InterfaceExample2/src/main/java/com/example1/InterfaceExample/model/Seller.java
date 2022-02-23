package com.example1.InterfaceExample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Seller {
	
	@Id
	int id;
	@Column(name="company")
	String Company;
	@Column(name="address")
	String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Seller(int id,String company, String address) {
		super();
		this.id=id;
		Company = company;
		this.address = address;
	}
	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
