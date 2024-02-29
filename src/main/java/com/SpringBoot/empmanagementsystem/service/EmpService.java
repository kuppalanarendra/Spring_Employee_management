package com.SpringBoot.empmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.empmanagementsystem.model.Employee;
import com.SpringBoot.empmanagementsystem.repository.EmployeeRepository;

@Service
public class EmpService {
	
	@Autowired
	private EmployeeRepository empRepository;
	
	public void createEmployee(Employee emp) {
		empRepository.save(emp);
	}
	public boolean validateLoginDetails( Employee emp) {
	 boolean status=false;
	 System.out.println(emp.getEmailid());
	 System.out.println(emp.getPassword());
	 
	 Employee existingEmp=this.empRepository.findByEmailid(emp.getEmailid());
	 if(existingEmp!=null &&(emp.getPassword().equals(existingEmp.getPassword())) ) {
			status=true;
			System.out.println("Validate is callled");
		}
	 return status;
	}
	public List<Employee> getEmployeeDetails() {
		List<Employee> empdetails= new ArrayList<>();
		return empRepository.findAll();
		
	}
	
	
	public Employee getEmployeeById(long employeeId) {
	Employee emp=	empRepository.findById(employeeId);
		
		return emp;
		
		
	}
	public void updateEmp(Employee emp) throws Exception {
		System.out.println("update method called");
		System.out.println(emp.getId());
		System.out.println(emp.getFirstname());
		System.out.println(emp.getLastname());
		System.out.println(emp.getPassword());
		System.out.println(emp.getPhonenumber());
		System.out.println(emp.getEmailid());
		System.out.println(emp.getAddress());
		if(emp!=null && emp.getId()!=0 ) {
			empRepository.save(emp);
		}
		else {
			throw new Exception("Invalid Object Employee");
		}
		
		System.out.println("updation performed");
		
		
		
	}
	public void deleteById(long employeeId) {
		Employee emp=empRepository.findById(employeeId);
		empRepository.delete(emp);
		
		
		
		
	}
	

}
