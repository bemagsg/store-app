package com.store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	Category findByCategoryName(String name);

	
}
