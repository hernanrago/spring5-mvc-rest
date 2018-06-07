package net.h3lv4ul7.springfamework.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.h3lv4ul7.springfamework.api.v1.model.CustomerDto;
import net.h3lv4ul7.springfamework.domain.Customer;
import net.h3lv4ul7.springfamework.repositories.CustomerRepository;
import net.h3lv4ul7.springfamework.services.CustomerService;
import net.h3lv4ul7.springfamework.api.v1.mapper.CustomerMapper;

@Service
@Slf4j
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
		return customerRepository
				.findAll()
				.stream()
				.map(customer -> {
					CustomerDto customerDto = customerMapper.customerToCustomerDto(customer);
					customerDto.setUrl("/api/v1/customers/" + customer.getName());
					return customerDto;
				})
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		CustomerDto savedCustomer = 
				customerMapper.customerToCustomerDto(customerRepository.save(customerMapper.customerDtoToCustomer(customerDto)));
		savedCustomer.setUrl("/api/v1/customer/" + customerDto.getId());
		return savedCustomer;
	}

	@Override
	public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
		customerDto.setId(id);
		customerDto.setUrl("/api/v1/customer/" + customerDto.getId());
		return customerMapper
				.customerToCustomerDto(customerRepository.save(customerMapper.customerDtoToCustomer(customerDto)));
		
	}

}
