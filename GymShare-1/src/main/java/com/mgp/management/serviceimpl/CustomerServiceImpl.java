package com.mgp.management.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mgp.management.model.Customer;
import com.mgp.management.repository.CustomerRepository;
import com.mgp.management.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	private CustomerRepository customerRepository; 
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

//	@Override
//	public Customer getCustomer(Customer customer) {
//		// TODO Auto-generated method stub
//		return customerRepository.findById(customer.get()).orElse(null);
//	}

//	@Override
//	public void deleteCustomer(String customer) {
//		// TODO Auto-generated method stub
//		
//	}

}
