package com.example.HotelRoomProject.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelRoomProject.Entity.Customer;
import com.example.HotelRoomProject.Repository.CustomerRepository;

@RestController
@RequestMapping("customers")

public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@GetMapping("list")
	List<Customer>getCustomers(){
		return customerRepo.findAll();
	}
	
	@GetMapping("/{customerid}")
	Optional<Customer> getCustomer(@PathVariable Long customerid){
		return customerRepo.findById(customerid);
	}
	
	@PostMapping("/new")
	String addNewCustomer(@RequestBody Customer customer) {	
		customerRepo.save(customer);
		return "Customer saved! The current number of customer is " +customerRepo.count();
	}
	
	@GetMapping("/delete/{customerid}")
	String deleteCustomer(@PathVariable Long customerid) {
		customerRepo.deleteById(customerid);
		return String.format("Customer deleted. %d ",customerid);
	}

}
