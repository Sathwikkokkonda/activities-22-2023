package com.npci.LoanApplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.npci.LoanApplication.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query("select e from Employee e where e.employeeName=?1 and e.password=?2 ")
	public List<Employee> getEmployee(String employeeName,String password);

}
