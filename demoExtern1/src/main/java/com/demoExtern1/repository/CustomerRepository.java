package com.demoExtern1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import com.demoExtern2.model;

import com.demoExtern1.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByAge(int age);
	
    @Query("SELECT p FROM Customer p WHERE LOWER(p.name) = LOWER(:name)")
    public List<Customer> findXyz(@Param("name") String name);
}
