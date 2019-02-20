package com.store.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prodId;
	private String productName;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	private Category category;

	private Product() {}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="product")
	@JsonIgnore
	private Set<Item> items;
	
	public Product(String productName, Category category) {
		
		
	
		this.productName = productName;
		this.category = category;
	}



	public Product( String productName) {

		this.productName = productName;
	}
	
	
}	