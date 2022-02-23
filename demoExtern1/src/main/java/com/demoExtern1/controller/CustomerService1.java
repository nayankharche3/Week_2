package com.demoExtern1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demoExtern1.model.Customer;
import com.demoExtern1.repository.CustomerRepository;

@Service
public class CustomerService1 {
	
	@Autowired
	CustomerService2 service2;
	
	@Autowired
	CustomerRepository repository;
	
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.MANDATORY)
	public Customer internalMethod(Customer customer)
	{
		Customer _customer = repository.save(new Customer(customer.getName()+"oooooo", customer.getAge()));
		//not commited
		
		Customer custom=service2.internalMethod1(_customer);
		System.out.println(custom.getName()+custom.getAge());
		
		//commited
		
		if(false) {
		//thorw exception so that book will not save in DB
		throw new RuntimeException("this exception in throwing intentionally");
		}
		
		return _customer;
	}

}
