package sube.interviews.mareoenvios.service.customer;

import java.util.Optional;

import sube.interviews.mareoenvios.entity.Customer;

public interface CustomerService {

	public Optional<Customer> findById(Integer id);
	
}
