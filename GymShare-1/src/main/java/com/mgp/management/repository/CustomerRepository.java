package com.mgp.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgp.management.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
