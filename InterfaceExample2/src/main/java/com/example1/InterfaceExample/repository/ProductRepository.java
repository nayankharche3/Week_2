package com.example1.InterfaceExample.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example1.InterfaceExample.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

//	Product save(Product product);
	Product deleteById(int id);//Derived Query
	Product findByNameAndPrice(String name,int id);//Derived
	@Query("SELECT u FROM Product u WHERE u.name = ?1 and u.price = ?2")//Custom Query
	List<Product> customfindByNameAndPrice(String name,int price);
	
	@Query("SELECT new com.example1.InterfaceExample.repository.ProductBasedOnNameAndPrice(u.name,u.price) FROM Product u")
	List<Product> findByNameANDPrice(String name,int price);
	
	
	

}
