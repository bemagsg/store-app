package com.store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Category;
import com.store.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByProductName(String name);

}
