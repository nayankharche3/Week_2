package com.example1.InterfaceExample.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.example1.InterfaceExample.External;
import com.example1.InterfaceExample.exception.ProductIdInvalidException;
import com.example1.InterfaceExample.model.External;
import com.example1.InterfaceExample.model.Product;
//import com.example1.InterfaceExample.service.ProductService;
import com.example1.InterfaceExample.service.ProductService1;


@RestController
public class ProductController {
	@Autowired
	ProductService1 productservice;
	

	
	private External external;

	@PostMapping("/AddProduct")
	public Product AddProduct(@RequestBody Product product)
	{
		return productservice.addProduct(product);
	}
	
	@GetMapping("/GetProduct/{id}")
	public Optional<Product> getProduct(@RequestHeader("id")@PathVariable int id)
	{
		return productservice.getProduct(id);
	}
	
	@GetMapping("/GetAllProduct")
	public List<Product> getAllProduct()
	{
		return productservice.getAllProduct();
	}
	
	@DeleteMapping("/delete")
	public Product deleteProduct(@RequestHeader("accept-language")int id)
	{
		return productservice.deleteProduct(id);
	}
	@PutMapping("/update")
	public void updateProduct(@RequestBody Product prod)
	{
		productservice.updateProduct(prod);
		System.out.println("Data updated");
	}
	
	@GetMapping("/getProcutbasedonname/{name}/{price}")
	public Product getProductBasedOnNameandPrice(@PathVariable String name,@PathVariable int price)
	{
		return productservice.getProductByNameAndPrice(name, price);
	}
	
	@GetMapping("custom/getProcutbasedonname/{name}/{price}")
	public List<Product> getProuctBasedOnNameAndPrice(@PathVariable String name,@PathVariable int  price)
	{
		return productservice.customgetProductByNameAndPrice(name, price);
	}
	
	@GetMapping("custom1/getProcutbasedonname/{name}/{price}")
	public List<Product> getProuctBasedOnNameAndPrice1(@PathVariable String name,@PathVariable int  price)
	{
		return productservice.customgetProductByNameAndPrice(name, price);
	}
	
	@GetMapping("/Pagination")
	public Page<Product> getUser(@RequestParam(defaultValue = "0")Integer pageNo, @RequestParam(defaultValue = "10")Integer pageSize,@RequestParam(defaultValue = "id") String sortBy)
    {
		
		return productservice.getUser(pageNo, pageSize,sortBy);
    }
	
	@GetMapping("/Hello")//RequestHeader Example(Assignment 1)
	public String Hello(@RequestHeader(value="user-agent")String useragent,@RequestHeader(value="accept")String accept,
			@RequestHeader(value="acceptLanguage",defaultValue = "Raaj")String acceptLanguage)
	{
		return productservice.Hello(useragent,accept,acceptLanguage);
	}
	
	
	
	
	
	

	

}
