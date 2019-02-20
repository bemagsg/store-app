package com.store.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;


import lombok.Data;

@Data
@Entity
public class Item {
	
	@Id 
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String description;
	
	private String brand;
	
	private float originalPrice;
	
	private float sellingPrice;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "productId")
	private Product product;

	private Item() {}
	
	public Item(String name, String description, String brand, float originalPrice, float sellingPrice,
			Product product) {
	
		
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.originalPrice = originalPrice;
		this.sellingPrice = sellingPrice;
		this.product = product;
	}

	public Item(String name, float originalPrice, float sellingPrice, Product product) {
		
		this.name = name;
		this.originalPrice = originalPrice;
		this.sellingPrice = sellingPrice;
		this.product = product;
	}

	public Item(String name, String description, float originalPrice, float sellingPrice, Product product) {
		
		this.name = name;
		this.description = description;
		this.originalPrice = originalPrice;
		this.sellingPrice = sellingPrice;
		this.product = product;
	}
	
	
	
	
	
	
	
	
	
	
	
}
