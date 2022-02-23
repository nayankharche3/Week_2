package com.resttemplate99.resttemplate99;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/*
 * This project invokes REST APIS exposed by spring-boot-rest-mysql(hence import this project as well)
 */

@SpringBootApplication
public class Resttemplate99Application {

	public static void main(String[] args) {
		SpringApplication.run(Resttemplate99Application.class, args);
	}
}

@RestController
class Sample {
	@GetMapping("/rstget1")
	public String met1() {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8429/api/customers";
		URI uri = null;
		try {
			uri = new URI(baseUrl);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		
		Customer[] custs=restTemplate.getForObject(uri, Customer[].class);

		// Verify request succeed
		System.out.println("Status code: " + result.getStatusCodeValue());
		System.out.println("result: " + result.getBody());

		return "Status code: " + result.getStatusCodeValue() + "<br>result: " + result.getBody();
	}

	@GetMapping("/rstget2")
	public String postCheck() {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8429/api/customers/create";
		URI uri = null;
		try {
			uri = new URI(baseUrl);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpHeaders headers = new HttpHeaders();
		
		Customer cust = new Customer(966, "cust99999999999999", 299);
		//Customer cust1 = new Customer(966, "Ganesh", 299);
		HttpEntity<Customer> entity = new HttpEntity<Customer>(cust, headers);
		ResponseEntity<Customer> result = restTemplate.postForEntity(uri,entity,Customer.class);
		//ResponseEntity<Customer> result1 = restTemplate.postForEntity(uri, entity,Customer.class);
		Customer obj = restTemplate.postForObject(uri,cust,Customer.class);
			System.out.println(obj.getName());
		System.out.println("Status Code: " + result.getStatusCodeValue() + result);

		return "Status Code: " + result.getStatusCodeValue() + result;
	}
	
	@GetMapping("/rstget3")
	public String postCheck1() {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8429/api/customers";
		URI uri = null;
		try {
			uri = new URI(baseUrl);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		Customer[] custs = restTemplate.getForObject(uri, Customer[].class);



		
		System.out.println("Status code: " + result.getStatusCodeValue());
		System.out.println("result: " + result.getBody());

		for (Customer c : custs) {
		System.out.println(c);
		}
		return "Status code: " + result.getStatusCodeValue() + "<br>result: " + result.getBody();
	
	}
	
	
	@PutMapping("/customers/1/{id}")
	public String updateProduct(@PathVariable("id") String id, @RequestBody Customer cust) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Customer> entity = new HttpEntity<Customer>(cust, headers);

		ResponseEntity<Customer> rcustomer = restTemplate.exchange("http://localhost:8429/api/customers/" + id,
				HttpMethod.PUT, entity, Customer.class);
		return rcustomer.toString();
	}
	
	@DeleteMapping("/customers/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> entity = new HttpEntity<>(headers);

 

        //(url, HttpMethod.DELETE, httpEntity, Void.class, empId);
        restTemplate.exchange("http://localhost:8429/api/customers/{id}", HttpMethod.DELETE, entity, Void.class,id);
        return "Deleted "+id;
    }
	
/*	@PutMapping("/customers/{id}")
	public String updateProduct(@PathVariable int id,Customer customer)
	{
		RestTemplate restTemplate=new RestTemplate();
		Customer cus=new Customer(1,"gagegeg",599);
		HttpHeaders header=new HttpHeaders();
		HttpEntity<Customer> entity=new HttpEntity<Customer>(cus,header);
		restTemplate.postForEntity("http://localhost:8080/customers/{id}",HttpMethod.PUT,entity,Customer.class,id);
		return "updated";
	}*/

}
