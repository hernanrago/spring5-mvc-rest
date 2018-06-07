package net.h3lv4ul7.springfamework.services;

import java.util.List;

import net.h3lv4ul7.springfamework.api.v1.model.CustomerDto;

public interface CustomerService {

	CustomerDto getCustomerByName(String name);
	
	List<CustomerDto> getCustomerList();
}
