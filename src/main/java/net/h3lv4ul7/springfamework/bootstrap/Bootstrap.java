package net.h3lv4ul7.springfamework.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import net.h3lv4ul7.springfamework.domain.Category;
import net.h3lv4ul7.springfamework.domain.Customer;
import net.h3lv4ul7.springfamework.repositories.CategoryRepository;
import net.h3lv4ul7.springfamework.repositories.CustomerRepository;

@Component
@Slf4j
public class Bootstrap implements CommandLineRunner{
	
	private CategoryRepository categoryRepository;
	private CustomerRepository customerRepository;

	public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.saveAll(createCustomers("Athos", "Porthos", "Aramis"));
		log.info("data loaded=" + customerRepository.count());
		
		categoryRepository.saveAll(createCategories("Fruits", "Dried", "Fresh", "Exotic", "Nuts"));
		log.info("Data loaded=" + categoryRepository.count());
		
	}
	
	public List<Category> createCategories(String... categoryName){
		List<Category> categories = new ArrayList<>();
		for(String s : categoryName) categories.add(new Category(s));
		return categories;		
	}
	
	public List<Customer> createCustomers(String... customerName){
		List<Customer> customers = new ArrayList<>();
		for(String s : customerName) customers.add(new Customer(s));
		return customers;		
	}

}
