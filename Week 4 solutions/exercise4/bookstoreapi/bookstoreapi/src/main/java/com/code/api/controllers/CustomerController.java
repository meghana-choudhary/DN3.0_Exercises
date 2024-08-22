package com.code.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.code.api.dto.CustomerDTO;
import com.code.api.entity.Customer;
import com.code.api.services.CustomerService;
import com.code.api.services.BookService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	private CustomerService customerService;
	public CustomerController(CustomerService customerService) {
	    this.customerService = customerService;
	}
	
	@GetMapping ("/test")
public String test()
{
		return "welcome";
}
	

@PostMapping("/register")
public ResponseEntity<Customer> registerCustomer(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String password) {

    Customer customer = new Customer(0,name, email, password);
    Customer savedCustomer = customerService.addCustomer(customer);
    return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
}
@GetMapping("/")
public ResponseEntity<List<CustomerDTO>> getAllCustomer(){
      
  return new ResponseEntity<>(customerService.getCustomer(),HttpStatus.OK);
   
}
@GetMapping("/{id}")
public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int id){
      
  return new ResponseEntity<>(customerService.getCustomerById(id),HttpStatus.OK);
   
}
@GetMapping("/me")
public ResponseEntity<Customer> authenticatedUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    Customer currentUser = (Customer) authentication.getPrincipal();

    return ResponseEntity.ok(currentUser);
}

}
