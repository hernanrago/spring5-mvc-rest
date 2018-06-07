package net.h3lv4ul7.springfamework.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import net.h3lv4ul7.springfamework.api.v1.model.CustomerDto;
import net.h3lv4ul7.springfamework.domain.Customer;

@Mapper
public interface CustomerMapper {
	
	CustomerMapper mapper = Mappers.getMapper(CustomerMapper.class);
	
	Customer customerDtoToCustomer(CustomerDto customerDto);
	
	CustomerDto customerToCustomerDto(Customer customer);
}
