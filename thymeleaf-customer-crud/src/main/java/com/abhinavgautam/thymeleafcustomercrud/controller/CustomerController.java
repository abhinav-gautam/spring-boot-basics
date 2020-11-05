package com.abhinavgautam.thymeleafcustomercrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhinavgautam.thymeleafcustomercrud.entity.Customer;
import com.abhinavgautam.thymeleafcustomercrud.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String getCustomer(Model model){
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers",customers);
		return "list-employees";
	}
	@GetMapping("/showAddForm")
	public String showAddForm(Model model){
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		return "add-form";
	}
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		return "redirect:/customers/list";
	}
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("customerId") int id ,Model model){
		Customer customer = customerService.findById(id);
		model.addAttribute("customer",customer);
		return "update-form";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id){
		customerService.delete(id);
		return "redirect:/customers/list";
	}
}
