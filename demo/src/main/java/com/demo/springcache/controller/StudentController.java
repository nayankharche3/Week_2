package com.demo.springcache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springcache.model.Student;
import com.demo.springcache.service.StudentServiceImpl;

//import com.example.springcache.domain.Student;
//import com.example.springcache.service.StudentServiceImpl;

@RestController
public class StudentController {
	
	@Autowired
	StudentServiceImpl studentService;
	
	@GetMapping("/student/{name}")
	public Student findStudentById(@PathVariable String name) {
		System.out.println("Searching by ID  : " + name);
		return studentService.getByName(name);
	}
	
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student student) {
		studentService.updateProduct(student);
		
		return student;
	}
	
	@GetMapping("/evict")
	public void evict()
	{
		studentService.refreshAllProducts();
		
	}
}
