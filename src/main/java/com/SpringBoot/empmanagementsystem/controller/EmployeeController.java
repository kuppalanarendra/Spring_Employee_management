package com.SpringBoot.empmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpringBoot.empmanagementsystem.model.Employee;
import com.SpringBoot.empmanagementsystem.service.EmpService;

@Controller
public class EmployeeController {

	@Autowired
	private EmpService empService;

	@GetMapping("/")
	public String hello() {
		return "index";
	}

	@GetMapping("/SignUp1")
	public String signUp() {
//		model.addAttribute("emp", new Employee());
		return "SignUp1";
	}

	@PostMapping("/SignUp12")
	public String signupSubmit(Employee emp) {
		empService.createEmployee(emp);
		return "login";

	}

	@GetMapping("/login12")
	public String login() {
		System.out.println("you are caling login12");

		return "login";

	}

	@PostMapping("/loginuser")
	public String validate(@ModelAttribute("emp") Employee emp) {
		boolean status = empService.validateLoginDetails(emp);
		System.err.println(status);
		if (status) {
			System.out.println("True");
			return "home";
		} else {
			return "invalid";
		}
	}

	@GetMapping("/view")
	public String getAllEmployee(Model model) {
		List<Employee> employees = empService.getEmployeeDetails();
		model.addAttribute("eachemp", employees);
		for (Employee emp : employees) {
			System.out.println(emp.getId());
		}

		// return employees;
		return "view";
	}

	@GetMapping("/get/{id}")

	public String update(@PathVariable(value = "id") long employeeId, Model model) {
		Employee emply = empService.getEmployeeById(employeeId);
		System.out.println(emply.getFirstname());
		model.addAttribute("emp", emply);
		return "edit";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("emp")Employee emp) throws Exception {
		System.out.println("post Method called");
		empService.updateEmp(emp);
		System.out.println("again comes to post");
		
		return "redirect:/view";
	}
	@RequestMapping("/del/{id}")
	public String delete(@PathVariable(value="id") long employeeId) {
		empService.deleteById(employeeId);
		
		return "redirect:/view";
	}
 
}
