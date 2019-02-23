package com.store;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.store.entity.Category;
import com.store.entity.Item;
import com.store.entity.Product;
import com.store.repositories.CategoryRepository;
import com.store.repositories.ItemRepository;
import com.store.repositories.ProductRepository;
import com.store.services.ItemServices;

@Component
public class DatabaseLoader implements CommandLineRunner{

	

	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final ItemRepository itemRepository;
	private final ItemServices itemServices;
	
	
	public DatabaseLoader(ItemServices itemServices, CategoryRepository categoryRepository, ProductRepository productRepository, ItemRepository itemRepository) {

		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.itemRepository = itemRepository;
		this.itemServices = itemServices;
	}
	
	@Override
	public void run(String...strings) throws Exception {
		
		
		/**
		Category food = new Category("Food & Drinks");
		categoryRepository.save(food);
		
		Set <Product> products = new HashSet<>();
		products.add(new Product("Noodles"));
		products.add(new Product("Canned Goods"));
		products.add(new Product("Candies"));
		products.add(new Product("Chips"));
		products.add(new Product("Food Ingredients"));
		products.add(new Product("Softdrinks"));
		products.add(new Product("Liquor"));
		
		
		for(Product prod : products) {
			
			prod.setCategory(food);
			productRepository.save(prod);
		}
		
		food.setProducts(products);
		
        
		
		Category grooming = new Category("Grooming Products");
		categoryRepository.save(grooming);
		
		Set <Product> gProducts = new HashSet<>();
		gProducts.add(new Product("Shampoo"));
		gProducts.add(new Product("Conditioner"));
		gProducts.add(new Product("Deo-lotion"));
		gProducts.add(new Product("Soap"));
		gProducts.add(new Product("Toothpaste"));
		
		for(Product prod : gProducts) {
			prod.setCategory(grooming);
			productRepository.save(prod);
		}
		grooming.setProducts(gProducts);
		
			
		
		Category cleaning = new Category("Cleaning Materials");
		categoryRepository.save(cleaning);
		
		Set<Product> cleanProducts = new HashSet<>();
		cleanProducts.add(new Product("Laundry Soap"));
		cleanProducts.add(new Product("Dishwashing Soap"));
		cleanProducts.add(new Product("Cleaning Materials"));
		cleanProducts.add(new Product("Fabric Conditioner"));
		cleanProducts.add(new Product("Others"));
		
		
		for(Product prod: cleanProducts) {
			prod.setCategory(cleaning);
			productRepository.save(prod);
		}
		cleaning.setProducts(cleanProducts);
		
		*/
		
		

		
		
		
	}
}
