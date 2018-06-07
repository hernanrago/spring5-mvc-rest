package net.h3lv4ul7.springfamework.api.v1.mapper;

import static org.junit.Assert.*;

import org.junit.Test;

import net.h3lv4ul7.springfamework.api.v1.model.CategoryDto;
import net.h3lv4ul7.springfamework.domain.Category;

public class CategoryMapperTest {
	
	private static final long ID = 1L;
	private static final String NAME = "Green";
	CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

	@Test
	public final void testCategoryToCategoryDTO() {
		Category category = new Category(NAME);
		category.setId(ID);
		
		CategoryDto categoryDto = categoryMapper.categoryToCategoryDTO(category);
		
		assertEquals(Long.valueOf(1L), categoryDto.getId());
		assertEquals(NAME, categoryDto.getName());
	}
}
