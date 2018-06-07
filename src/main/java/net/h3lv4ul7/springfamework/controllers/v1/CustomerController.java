package net.h3lv4ul7.springfamework.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import net.h3lv4ul7.springfamework.api.v1.model.CustomerDto;
import net.h3lv4ul7.springfamework.api.v1.model.CustomerListDto;
import net.h3lv4ul7.springfamework.services.CustomerService;

@Controller
@RequestMapping("/api/v1/customers")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("{name}")
	public ResponseEntity<CustomerDto> getCustomerByName(@PathVariable String name){
		return new ResponseEntity<CustomerDto>(
				customerService.getCustomerByName(name), HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<CustomerListDto> getCustomerList(){
		return new ResponseEntity<CustomerListDto>(
				new CustomerListDto(customerService.getCustomerList()), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
		return new ResponseEntity<CustomerDto>(
				customerService.createCustomer(customerDto), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto){
		return new ResponseEntity<CustomerDto>(
				customerService.updateCustomer(id, customerDto), HttpStatus.OK);
	}
}
