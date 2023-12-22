package com.npci.LoanApplication.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.npci.LoanApplication.entity.Credit_Score;
import com.npci.LoanApplication.entity.Customer;
import com.npci.LoanApplication.entity.Employee;
import com.npci.LoanApplication.service.Service;



@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	private Service service;
	
	@GetMapping(path="/employee/{name}/{password}")
	public ResponseEntity<Object> getEmployee(@PathVariable("name") String name,@PathVariable
			("password") String password){  
		
		List<Employee> employee = service.getEmployeeDetails(name, password);
		return ResponseEntity.status(200).body(employee);
	}

	@PostMapping(path="/registration",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> storeCustomer(@RequestBody Customer customer){
		
		 	Customer storedCustomer = service.storeCustomer(customer);

	        return ResponseEntity.status(HttpStatus.OK).body(storedCustomer);
	}
	
	 @PostMapping("/login")
	    public ResponseEntity<Object> login(@RequestBody Map<String, String> credentials) {
	        String emailId = credentials.get("emailId");
	        String password = credentials.get("password");

	        Optional<Customer> user = service.loginUser(emailId, password);

	        if (user.isPresent()) {
	            return ResponseEntity.ok("Login successful");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	        }
	    }
	
}
