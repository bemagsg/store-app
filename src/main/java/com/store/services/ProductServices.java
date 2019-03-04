package com.store.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.store.entity.Category;
import com.store.entity.Item;
import com.store.entity.Product;
import com.store.repositories.CategoryRepository;
import com.store.repositories.ItemRepository;
import com.store.repositories.ProductRepository;

@Service
public class ProductServices {

	
	private ProductRepository prodRepository;
	private CategoryRepository catRepository;
	private ItemRepository itemRepository;
	
	ProductServices (ProductRepository prodRepository, CategoryRepository catRepository, ItemRepository itemRepository){
		this.prodRepository = prodRepository;
		this.catRepository = catRepository;
		this.itemRepository = itemRepository;
		
	}
	
	public void saveProd(Product newProduct) {
		
		Category category = catRepository.findByCategoryName(newProduct.getCategory().getCategoryName());
		if(category==null) catRepository.save(newProduct.getCategory());
		else newProduct.setCategory(category);
		
		Product product = prodRepository.findByProductName(newProduct.getProductName());
		if(product==null) prodRepository.save(newProduct);
		
		
		  
	}
	
	public List<Product> getAllProduct() {
		
		return prodRepository.findAll();
		
	
	}
	
	public void deleteProduct(Long id) {
		
		prodRepository.deleteById(id);
		
	}
	
	public void deleteCategory(Long id) {
		
		catRepository.deleteById(id);
		
	}
	
	public List<Category> getAllCategory() {
		
		return catRepository.findAll();
	}
	
	public List<Item> getAllItems(Long id) {
		List<Item> oldItem = itemRepository.findAll();
		List<Item> newItem = new ArrayList<>();
		
		for(Item item : oldItem) {
			if(item.getProduct().getProdId() == id) {
				newItem.add(item);
			}
		}
		
		return newItem;
	}

	public List<Product> getAllProductsByName(String name) {
		List<Product> oldProd = prodRepository.findAll();
		List<Product> newProd = new ArrayList<>();
		
		for(Product prod : oldProd) {
			if(prod.getCategory().getCategoryName().equals(name)) {
				newProd.add(prod);
			}
		}
		
		return newProd;
	}

	
}
