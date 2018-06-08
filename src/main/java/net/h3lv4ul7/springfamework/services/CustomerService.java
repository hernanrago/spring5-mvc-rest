package net.h3lv4ul7.springfamework.services;

import java.util.List;

import net.h3lv4ul7.springfamework.api.v1.model.CustomerDto;

public interface CustomerService {
	
	CustomerDto createCustomer(CustomerDto customerDto);

	CustomerDto getCustomerByName(String name);
	
	CustomerDto updateCustomer(Long id, CustomerDto customerDto);
	
	CustomerDto patchCustomer(Long id, CustomerDto customerDto);
	
	void deleteCustomer(Long id);
		
	List<CustomerDto> getCustomerList();
}
