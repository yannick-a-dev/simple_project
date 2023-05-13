package com.springCrud.springAngular.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springCrud.springAngular.dto.CustomerDto;
import com.springCrud.springAngular.dto.CustomerSaveDto;
import com.springCrud.springAngular.dto.CustomerUpdateDto;
import com.springCrud.springAngular.service.CustomerService;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin("*")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping(path = "/save")
	public String saveCustomer(@RequestBody CustomerSaveDto customerSaveDto) {
		
		String id = customerService.addCustomer(customerSaveDto);
		return id;
		
	}
	
	@GetMapping(path = "/getAllCustomer")
	public List<CustomerDto> getAllCustomer() {
		List<CustomerDto> allCustomers = customerService.getAllCustomer();
		return allCustomers;
	}
	
	@PutMapping(path = "/update")
	public String updateCustomer(@RequestBody CustomerUpdateDto customerUpdateDto) {
		String id = customerService.updateCustomers(customerUpdateDto);
		return id;
	}
	
	@DeleteMapping(path = "/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable(value = "id") int id) {
		boolean deleteCustomer = customerService.deleteCustomer(id);
		return "deleted";
	}
}
