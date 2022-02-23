package com.example1.InterfaceExample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

//import com.cj.spring.bean.User;
import com.example1.InterfaceExample.model.Product;
import com.example1.InterfaceExample.repository.ProductRepository;


@Service
public class ProductService1  {
	
	@Autowired
	ProductRepository prodRepo;
	
	public Product addProduct(Product product)
	{
		Product p=prodRepo.save(product);
		return p;
	}
	
	public Optional<Product> getProduct(int id)
	{
		Optional<Product> p=prodRepo.findById(id);
		return p;
	}
	
	public List<Product> getAllProduct()
	{
		List<Product> l=prodRepo.findAll();
		return l;
	}
	
	public Product deleteProduct(int id)
	{
		
		return prodRepo.deleteById(id);
		
	}
	
	public  void updateProduct(Product prod)
	{
		prodRepo.save(prod);
	}
	
	public Product getProductByNameAndPrice(String name,int price)
	{

	Product p=prodRepo.findByNameAndPrice(name,price);
	return p;
	}
	
	public List<Product> customgetProductByNameAndPrice(String name,int price)
	{
		List<Product> p=prodRepo.customfindByNameAndPrice(name, price);
		return p;
	}
	public Page<Product> getUser(int pageno,int pageSize,String sortBy)
	{
		Pageable paging = PageRequest.of(pageno, pageSize, Sort.by(Sort.Direction.DESC, sortBy));
		
        Page<Product> pagedResult = prodRepo.findAll(paging);
        return pagedResult;
	}
	
	public String Hello(String useragent,String accept,String AcceptLanguage)
	{
	System.out.println(useragent+AcceptLanguage+accept);
	return "Hello";
	}
	
	
}