package net.h3lv4ul7.springfamework.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import net.h3lv4ul7.springfamework.api.v1.model.CategoryDto;
import net.h3lv4ul7.springfamework.api.v1.model.CategoryListDto;
import net.h3lv4ul7.springfamework.services.CategoryService;

@AllArgsConstructor
@Controller
@RequestMapping(CategoryController.API_V1_CATEGORIES)
public class CategoryController {

	public static final String API_V1_CATEGORIES = "/api/v1/categories/";
	private final CategoryService categoryService;

	@GetMapping
	public ResponseEntity<CategoryListDto>listCategories() {
		return new ResponseEntity<CategoryListDto>(
				new CategoryListDto(categoryService.getAllCategories()), HttpStatus.OK);
	}
	
	@GetMapping("{name}")
	public ResponseEntity<CategoryDto>getCategoryByName(String name){
		return new ResponseEntity<CategoryDto>(
				categoryService.getCategoryByName(name), HttpStatus.OK);
	}

}
