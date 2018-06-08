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
	
	public static final String API_V1_CUSTOMERS = "/api/v1/customers/";
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
					customerDto.setUrl(API_V1_CUSTOMERS + customer.getName());
					return customerDto;
				})
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		CustomerDto savedCustomer = 
				customerMapper.customerToCustomerDto(customerRepository.save(customerMapper.customerDtoToCustomer(customerDto)));
		savedCustomer.setUrl(API_V1_CUSTOMERS + customerDto.getId());
		return savedCustomer;
	}

	@Override
	public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
		customerDto.setId(id);
		customerDto.setUrl(API_V1_CUSTOMERS + customerDto.getId());
		return customerMapper
				.customerToCustomerDto(customerRepository.save(customerMapper.customerDtoToCustomer(customerDto)));
	
	}

	@Override
	public CustomerDto patchCustomer(Long id, CustomerDto customerDto) {
		return customerRepository.findById(id).map(customer -> {
			if(customerDto.getName() != null) {
				customer.setName(customerDto.getName());
				customer.setUrl(API_V1_CUSTOMERS + customer.getName());
			}
			return customerMapper.customerToCustomerDto(customerRepository.save(customer));
		}).orElseThrow(RuntimeException::new);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
}