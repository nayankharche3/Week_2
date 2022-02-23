package com.demoExtern1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demoExtern1.model.Customer;
import com.demoExtern1.repository.CustomerRepository;

@Service
public class CustomerService2 {
	@Autowired
	CustomerRepository repository;
	
	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.MANDATORY)
	//You may also check behavior with Propogation.REQUIRED, MANDATORY, NOT_SUPPORTED, NEVER
	//@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)
	public Customer internalMethod1(Customer customer)
	{
		Customer _customer = repository.save(new Customer(customer.getName()+"1111111", customer.getAge()));
		//since new transaction is started, above record gets saved as no exceptions are thrown here
		System.out.println("Ganesh Raaj");
		return _customer;
	}
}
