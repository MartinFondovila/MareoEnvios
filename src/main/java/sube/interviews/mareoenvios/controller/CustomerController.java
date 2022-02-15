package sube.interviews.mareoenvios.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sube.interviews.mareoenvios.entity.Customer;
import sube.interviews.mareoenvios.service.customer.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/info/{customerid}")
	public ResponseEntity<?> getCustomerById(@PathVariable Integer customerid) {
		Optional<Customer> oCustomer = customerService.findById(customerid);
		if(!oCustomer.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oCustomer);
	}
	
}
