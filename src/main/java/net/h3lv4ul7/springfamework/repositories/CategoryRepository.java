package net.h3lv4ul7.springfamework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.h3lv4ul7.springfamework.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByName(String name);
}
