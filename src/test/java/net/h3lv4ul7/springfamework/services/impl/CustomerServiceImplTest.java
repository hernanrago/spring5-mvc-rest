package net.h3lv4ul7.springfamework.services.impl;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import net.h3lv4ul7.springfamework.api.v1.model.CustomerDto;
import net.h3lv4ul7.springfamework.domain.Customer;
import net.h3lv4ul7.springfamework.repositories.CustomerRepository;
import net.h3lv4ul7.springfamework.services.CustomerService;
import net.h3lv4ul7.springfamework.api.v1.mapper.CustomerMapper;

public class CustomerServiceImplTest {
	
	
	private final Long ID = 1L;
	private final String NAME = "Ash";
	CustomerService customerService;
	
	@Mock
	CustomerRepository customerRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		customerService = 
				new CustomerServiceImpl(customerRepository, CustomerMapper.mapper);
	}

	@Test
	public final void testGetCustomerByName() {
		Customer customer = new Customer(NAME);
		customer.setId(ID);
		
		when(customerRepository.findByName(anyString())).thenReturn(customer);
		
		CustomerDto customerDto = customerService.getCustomerByName(NAME);
		
		assertEquals(ID, customerDto.getId());
		assertEquals(NAME, customerDto.getName());
	}

	@Test
	public final void testGetCustomerList() {
	}
}
