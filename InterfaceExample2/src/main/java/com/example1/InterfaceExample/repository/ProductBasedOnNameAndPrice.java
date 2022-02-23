package com.example1.InterfaceExample.repository;

import java.io.Serializable;

public class ProductBasedOnNameAndPrice implements Serializable {
	
	String name;
	int price;
	
	public ProductBasedOnNameAndPrice()
	{
		super();
	}
	public ProductBasedOnNameAndPrice(String name, int price) {
		super();
		this.name = name;
		this.price = price;
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
	
	

}
