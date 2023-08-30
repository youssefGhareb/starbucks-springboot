package com.itworx.starbucksspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itworx.starbucksspringboot.model.OrderProduct;
import com.itworx.starbucksspringboot.repository.OrderProductRepository;

@Service
public class OrderProductService {

	@Autowired
	private OrderProductRepository repo;

	public Optional<OrderProduct> getOrderProducts(Long id) {
		return repo.findById(id);
	}

	public OrderProduct createOrderProduct(OrderProduct o) {
		return repo.save(o);
	}

	public void deleteOrderProduct(Long id) {
		repo.deleteById(id);
	}

	public List<OrderProduct> listOrderProducts() {
		return (List<OrderProduct>) repo.findAll();
	}
}
