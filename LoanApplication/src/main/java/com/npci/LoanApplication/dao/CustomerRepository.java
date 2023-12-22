package com.npci.LoanApplication.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npci.LoanApplication.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
	 Optional<Customer> findByEmailIdAndPassword(String emailId, String password);
}
