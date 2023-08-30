package com.itworx.starbucksspringboot.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long productId;
	@Column(name = "product_title")
	private String title;
	@Column(name="product_price")
	private double price;
	
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<OrderProduct> orderProducts;
	
	public Product () {
		
	}
	
	public Product(String title, double price) {
		super();
		this.title = title;
		this.price = price;
	}

	public Long getId() {
		return productId;
	}

	public void setId(Long id) {
		this.productId = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + productId + ", title=" + title + ", price=" + price + "]";
	}
	
	
	
}
