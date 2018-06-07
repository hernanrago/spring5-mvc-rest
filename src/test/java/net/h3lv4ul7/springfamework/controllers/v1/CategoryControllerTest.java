package net.h3lv4ul7.springfamework.controllers.v1;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import net.h3lv4ul7.springfamework.api.v1.model.CategoryDto;
import net.h3lv4ul7.springfamework.services.CategoryService;

public class CategoryControllerTest {
	
	public static final String NAME = "Freddy";
	
	@Mock
	CategoryService categoryService;
	
	@InjectMocks
	CategoryController categoryController;
	
	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
	}

	@Test
	public final void testListCategories() throws Exception{
		CategoryDto categoryDto1 = new CategoryDto(NAME);
		categoryDto1.setId(1L);
		CategoryDto categoryDto2 = new CategoryDto("Jason");
		categoryDto2.setId(2L);
		
		List<CategoryDto> categories = Arrays.asList(categoryDto1, categoryDto2);
		
		when(categoryService.getAllCategories()).thenReturn(categories);
		
		mockMvc.perform(get("/api/v1/categories")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.categories", hasSize(2)));		
	}
	
	@Test
	public void TestGetCategoryByName() throws Exception{ 
		CategoryDto categoryDto = new CategoryDto("Ash");
		categoryDto.setId(1L);
		
		when(categoryService.getCategoryByName(anyString())).thenReturn(categoryDto);
		
		mockMvc.perform(get("/api/v1/categories/Ash")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name", equalTo("Ash")));
	}
}
