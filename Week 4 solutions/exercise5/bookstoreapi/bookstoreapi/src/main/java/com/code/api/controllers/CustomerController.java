package com.code.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.api.entity.Customer;
import com.code.api.services.BookService;
import com.code.api.services.CustomerService;

@Controller
@RequestMapping("/api/customers")
public class CustomerController {
	private CustomerService customerService;
	public CustomerController(CustomerService customerService) {
	    this.customerService = customerService;
	}
	
	@RequestMapping ("/test")
public String test()
{
		return "welcome";
}
	
@RequestMapping("/add")
public String add(Model model)
{
	model.addAttribute("customer", new Customer());
	return "registration";
}
@RequestMapping(value="save",method = RequestMethod.POST)
public String save(@ModelAttribute("customer")Customer customer)
{
	//model.addAttribute("customer", new Customer());
	System.out.println(customer.getEmailid());
	return "registration";
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
}
