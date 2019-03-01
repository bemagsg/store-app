package com.store.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.entity.Category;
import com.store.entity.Item;
import com.store.entity.Product;
import com.store.repositories.CategoryRepository;
import com.store.repositories.ProductRepository;
import com.store.services.ItemServices;
import com.store.services.ProductServices;

@RestController

public class ProductController {
	
	@Autowired
	private ProductServices prodServices;
	
	
	@PostMapping("/product/new")
	public String createProduct(@RequestBody Product product) {
		prodServices.saveProd(product);
		return "added successfully";
	}
	
	@GetMapping("/products")
	public List<Product> getAllProduct() {
		return prodServices.getAllProduct();
	}
	
	@GetMapping("/categories")
	public List<Category> getAllCategory() {
		return prodServices.getAllCategory();
	}
	
	@GetMapping("/product/{id}")
	public List<Item> getAllItems(@PathVariable Long id) {
		return prodServices.getAllItems(id);
	}
	
	
	@GetMapping("/productsby")
	public List<Product> getAllProductsByName(@RequestParam String name) {
		return prodServices.getAllProductsByName(name);
	}
}
