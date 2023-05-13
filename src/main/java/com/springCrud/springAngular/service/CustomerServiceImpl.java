package com.springCrud.springAngular.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springCrud.springAngular.dto.CustomerDto;
import com.springCrud.springAngular.dto.CustomerSaveDto;
import com.springCrud.springAngular.dto.CustomerUpdateDto;
import com.springCrud.springAngular.model.Customer;
import com.springCrud.springAngular.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	@Override
	public String addCustomer(CustomerSaveDto customerSaveDto) {
		Customer customer = new Customer(
				
				customerSaveDto.getCustomerName(),
				customerSaveDto.getCustomerAddress(),
				customerSaveDto.getMobile()
				);
		customerRepo.save(customer);
		return customer.getCustomerName();
	}
	@Override
	public List<CustomerDto> getAllCustomer() {
		List<Customer> getCustomers = customerRepo.findAll();
		List<CustomerDto> cuList = new ArrayList<>();
		for(Customer a:getCustomers) {
			CustomerDto customerDto = new CustomerDto(
					a.getCustomerId(),
					a.getCustomerName(),
					a.getCustomerAddress(),
					a.getMobile());
			cuList.add(customerDto);
		}
		return cuList;
	}
	@Override
	public String updateCustomers(CustomerUpdateDto customerUpdateDto) {
		if(customerRepo.existsById(customerUpdateDto.getCustomerId())) {
			@SuppressWarnings("deprecation")
			Customer customer = customerRepo.getById(customerUpdateDto.getCustomerId());
			customer.setCustomerName(customerUpdateDto.getCustomerName());
			customer.setCustomerAddress(customerUpdateDto.getCustomerAddress());
			customer.setMobile(customerUpdateDto.getMobile());
			customerRepo.save(customer);
		}else {
			System.out.println("Customer ID do not exist");
		}
		return null;
	}
	@Override
	public boolean deleteCustomer(int id) {
	    if(customerRepo.existsById(id)) {
	    	customerRepo.deleteById(id);
	    }else {
	    	System.out.println("Customer ID do not found");
	    }
		return true;
	}

}
