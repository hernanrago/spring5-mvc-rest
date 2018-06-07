package net.h3lv4ul7.springfamework.controllers.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.h3lv4ul7.springfamework.api.v1.model.CustomerDto;
import net.h3lv4ul7.springfamework.services.CustomerService;

@Controller
@RequestMapping("/api/v1/customers/")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("{name}")
	public ResponseEntity<CustomerDto> getCustomerByName(String name){
		return new ResponseEntity<CustomerDto>(
				customerService.getCustomerByName(name), HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<CustomerDto>> getCustomerList(){
		return new ResponseEntity<List<CustomerDto>>(
				customerService.getCustomerList(), HttpStatus.OK);
	}
}
