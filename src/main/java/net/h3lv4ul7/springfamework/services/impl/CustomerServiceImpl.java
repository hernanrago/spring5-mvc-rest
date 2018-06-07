package net.h3lv4ul7.springfamework.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.h3lv4ul7.springfamework.api.v1.model.CustomerDto;
import net.h3lv4ul7.springfamework.repositories.CustomerRepository;
import net.h3lv4ul7.springfamework.services.CustomerService;
import net.h3lv4ul7.springfamework.api.v1.mapper.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;

	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Override
	public CustomerDto getCustomerByName(String name) {
		return customerMapper.customerToCustomerDto(
				customerRepository.findByName(name));
	}

	@Override
	public List<CustomerDto> getCustomerList() {
		return customerRepository.findAll()
				.stream().map(customerMapper::customerToCustomerDto)
				.collect(Collectors.toList());
	}

}
