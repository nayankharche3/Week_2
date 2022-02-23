package com.demo.springcache.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.springcache.model.Student;

//import com.example.springcache.domain.Student;

@Service
public class StudentServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	private static List<Student> products;

	static {
		products = getDummyProducts();
	}

	@Cacheable(value = "products", key = "#name", unless = "#result==null")
	// @Cacheable(value="products", key="#name", unless="#result==null")
	public Student getByName(String name) {

		logger.info("<!----------Entering getByName()--------------------->");
		// Database Interaction
		// INvoke WebService to retrieve data
		for (Student p : products) {
			if (p.getName().equalsIgnoreCase(name))
				return p;
		}
		return null;
	}

	@CacheEvict(value = "products", allEntries = true)
	public void refreshAllProducts() {
		// This method will remove all 'products' from cache, say as a result of flush
		// API.
		//List<Student> prod;
		//p
		//System.out.println(prod);
		
	}

	@CachePut(value = "products", key = "#product.name", unless = "#result==null")
	public Student updateProduct(Student product) {
		logger.info("<!----------Entering updateProduct ------------------->");
		for (Student p : products) {
			if (p.getName().equalsIgnoreCase(product.getName())) {
				p.setId(product.getId());
				p.setClz(product.getClz());
			return p;
			}
		}
		return null;
	}

	private static List<Student> getDummyProducts() {
		List<Student> products = new ArrayList<Student>();
		products.add(new Student("1", "name1", "class1"));
		products.add(new Student("2", "name2", "class2"));
		products.add(new Student("3", "name3", "class3"));
		return products;
	}

}
