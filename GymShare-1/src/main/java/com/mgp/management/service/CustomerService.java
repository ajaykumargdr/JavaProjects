package com.mgp.management.service;

import java.util.List;

import com.mgp.management.model.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();
	
	public void saveCustomer(Customer customer);
	
//	public List<Customer> getAllCustomers();
	
//	public Customer getCustomer(Customer customer);
	
//	public void deleteCustomer(String customer);
	

}
