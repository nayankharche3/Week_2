package com.example1.InterfaceExample.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private int price;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Seller seller;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Product(int id, String name, int price,Seller seller) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.seller=seller;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
