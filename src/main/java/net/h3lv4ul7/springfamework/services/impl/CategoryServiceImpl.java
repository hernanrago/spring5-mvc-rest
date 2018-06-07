package net.h3lv4ul7.springfamework.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.h3lv4ul7.springfamework.api.v1.mapper.CategoryMapper;
import net.h3lv4ul7.springfamework.api.v1.model.CategoryDto;
import net.h3lv4ul7.springfamework.repositories.CategoryRepository;
import net.h3lv4ul7.springfamework.services.CategoryService;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryMapper categoryMapper;
	private final CategoryRepository categoryRepository;

	@Override
	public List<CategoryDto> getAllCategories() {
		return categoryRepository.findAll()
				.stream()
				.map(categoryMapper::categoryToCategoryDTO)
				.collect(Collectors.toList());
	}

	@Override
	public CategoryDto getCategoryByName(String name) {
		return categoryMapper
				.categoryToCategoryDTO(categoryRepository.findByName(name));
	}
}
