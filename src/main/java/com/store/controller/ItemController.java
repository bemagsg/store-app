package com.store.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.entity.Item;
import com.store.services.ItemServices;

@RestController
@RequestMapping("/product")
public class ItemController {
	
	
	@Autowired
	private ItemServices itemServices;
	
	@PostMapping("/item")
	public ResponseEntity<Item> create(@Valid @RequestBody Item item)throws URISyntaxException {
		Item result = itemServices.saveItem(item);
		return ResponseEntity.created(new URI("/api/product/item/" + result.getId()))
				.body(result);
	}
	
	
	@GetMapping("/items")
	public Collection<Item> getAll(){
		return itemServices.getAll();
	}
	
	
	@GetMapping("/item/{id}")
	public Optional<Item> getItem(@PathVariable Long id) {
		return itemServices.getItem(id);
	}
	
	@PutMapping("/item")
	public ResponseEntity<Item> edit(@Valid @RequestBody Item item) {
		Item result = itemServices.saveItem(item);
        return ResponseEntity.ok().body(result);
		
	}
	
	@DeleteMapping("/item/{id}")
	public void delete(@PathVariable Long id) {
		itemServices.deleteItem(id);
		
	}
	
}
