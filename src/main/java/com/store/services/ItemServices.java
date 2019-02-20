package com.store.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.store.entity.Category;
import com.store.entity.Item;
import com.store.entity.Product;
import com.store.repositories.CategoryRepository;
import com.store.repositories.ItemRepository;
import com.store.repositories.ProductRepository;

@Service
public class ItemServices {

	
	private ProductRepository prodRepository;
	private CategoryRepository catRepository;
	private ItemRepository itemRepository;
	
	ItemServices (ProductRepository prodRepository, CategoryRepository catRepository, ItemRepository itemRepository){
		this.prodRepository = prodRepository;
		this.catRepository = catRepository;
		this.itemRepository = itemRepository;
	}
	
	
	
	public Item saveItem(Item newItem) {
		
		Category category = catRepository.findByCategoryName(newItem.getProduct().getCategory().getCategoryName());
		if(category == null) catRepository.save(newItem.getProduct().getCategory());
		else newItem.getProduct().setCategory(category);
		
		Product product = prodRepository.findByProductName(newItem.getProduct().getProductName());
		if(product == null) prodRepository.save(newItem.getProduct());
		else newItem.setProduct(product);
		
		Item item = itemRepository.save(newItem);
		
		return item;
	}
	
	public void deleteItem(Long id) {
		
		itemRepository.deleteById(id);
		
	}
	
	public Collection<Item> getAll(){
		
		return itemRepository.findAll();
	}
	
	public Optional<Item> getItem(Long id) {
		return itemRepository.findById(id);
	}
	
	
}
