package net.h3lv4ul7.springfamework.services;

import java.util.List;

import net.h3lv4ul7.springfamework.api.v1.model.CategoryDto;

public interface CategoryService {
	
	List<CategoryDto> getAllCategories();
	
	CategoryDto getCategoryByName(String name);

}
