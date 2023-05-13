package com.springCrud.springAngular.service;

import java.util.List;

import com.springCrud.springAngular.dto.CustomerDto;
import com.springCrud.springAngular.dto.CustomerSaveDto;
import com.springCrud.springAngular.dto.CustomerUpdateDto;

public interface CustomerService {

	String addCustomer(CustomerSaveDto customerSaveDto);

	List<CustomerDto> getAllCustomer();

	String updateCustomers(CustomerUpdateDto customerUpdateDto);

	boolean deleteCustomer(int id);

}
