package com.SpringBoot.empmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.SpringBoot.empmanagementsystem.model.Employee;
import com.SpringBoot.empmanagementsystem.repository.EmployeeRepository;

@Controller
public class EmpController {
	
//	@Autowired
//	private EmployeeRepository empRepository;
//	@GetMapping("/loginuser")
//	public String validateLogin(@ModelAttribute("emp") Employee emp) {
//		Employee existingEmp=this.empRepository.findByEmailid(emp.getEmailid());
//		
//		if(existingEmp!=null &&(emp.getPassword().equals(existingEmp.getPassword())) ) {
//			return "home";
//		}
//		else {
//			return "Invalid Credentials";
//		}
//		
//		
//		
//	}

}
