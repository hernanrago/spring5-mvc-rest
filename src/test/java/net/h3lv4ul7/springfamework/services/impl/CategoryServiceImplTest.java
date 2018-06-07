package net.h3lv4ul7.springfamework.services.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import net.h3lv4ul7.springfamework.api.v1.model.CategoryDto;
import net.h3lv4ul7.springfamework.domain.Category;
import net.h3lv4ul7.springfamework.repositories.CategoryRepository;
import net.h3lv4ul7.springfamework.services.CategoryService;
import net.h3lv4ul7.springfamework.api.v1.mapper.CategoryMapper;

public class CategoryServiceImplTest {
	
	public static final Long ID = 1L;
	public static final String NAME = "Jimmy";
	CategoryService categoryService;
	
	@Mock
	CategoryRepository categoryRepository;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);
	}

	@Test
	public final void testGetAllCategories() {
		List<Category> categories = Arrays.asList(new Category("One"), new Category("Two"), new Category("Three"));
		
		when(categoryRepository.findAll()).thenReturn(categories);
		
		List<CategoryDto> categoryDtos = categoryService.getAllCategories();
		
		assertEquals(3, categoryDtos.size());
	}

	@Test
	public final void testGetCategoryByName() {
		Category category = new Category(NAME);
		category.setId(ID);
		
		when(categoryRepository.findByName(anyString())).thenReturn(category);
		
		CategoryDto categoryDto = categoryService.getCategoryByName(NAME);
		
		assertEquals(ID, categoryDto.getId());
		assertEquals(NAME, categoryDto.getName());
	}

}
