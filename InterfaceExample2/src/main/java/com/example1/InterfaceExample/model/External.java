package com.example1.InterfaceExample.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class External {
	
	@Value("${companyname}")
	private String companyname;
	
	@PostConstruct
	  public String print() {
	    System.out.println("wwwwwwwwwww:"+companyname);
	    return companyname;
	  }
	 
	 @GetMapping(value="/company")
		public String getCompany()
		{
		 String n=print();
			System.out.println(n);
			return n;
		}

}
