package net.h3lv4ul7.springfamework.controllers.v1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import net.h3lv4ul7.springfamework.api.v1.model.CustomerDto;
import net.h3lv4ul7.springfamework.services.CustomerService;

public class CustomerControllerTest extends AbstractRestControllerTest{

	private static final String NAME = "Michael Myers";

	private static final Long ID = 1L;

	@Mock
	CustomerService customerService;
	
	@InjectMocks
	CustomerController customerController;
	
	MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@Test
	public final void testGetCustomerByName() {
	}

	@Test
	public final void testGetCustomerList() {
	}
	
	@Test
	public final void testCreateCustomer() throws Exception {
		CustomerDto customerDto = new CustomerDto(NAME);
		customerDto.setId(ID);
		
		CustomerDto returnedCustomerDto = new CustomerDto();
		returnedCustomerDto.setName(customerDto.getName());
		returnedCustomerDto.setUrl("/api/v1/customers/1");
		
		when(customerService.createCustomer(customerDto)).thenReturn(returnedCustomerDto);
		
		mockMvc.perform(post("/api/v1/customers/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(customerDto)))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.name", equalTo(NAME)))
		.andExpect(jsonPath("$.customer_url" , equalTo("/api/v1/customers/1")));
		
	}

}
