package com.SpringBoot.empmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.empmanagementsystem.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	Employee findByEmailid(String emailid );
	
	Employee findById(Long employeeId);

}
