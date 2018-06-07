package net.h3lv4ul7.springfamework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.h3lv4ul7.springfamework.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	Customer findByName(String name);
}
