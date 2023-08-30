package com.itworx.starbucksspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itworx.starbucksspringboot.model.Product;
import com.itworx.starbucksspringboot.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	public Optional<Product> getProduct(Long id) {
		return productRepo.findById(id);
	}

	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}

	public List<Product> listProducts() {
		return (List<Product>) productRepo.findAll();
	}
}
